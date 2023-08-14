package com.traderdetector;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.network.packet.c2s.play.ClientStatusC2SPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ExampleModClient implements ClientModInitializer {

	private final Set<UUID> handledTraders = new HashSet<>();
	private final File dataFile = new File("wandering_traders.dat");

	@Override
	public void onInitializeClient() {
		loadHandledTraders();

		ClientEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof WanderingTraderEntity) {
				UUID traderUuid = entity.getUuid();
				if (!handledTraders.contains(traderUuid)) {
					handledTraders.add(traderUuid);
					saveHandledTraders();
					// 当检测到流浪商人生成时，向服务器发送断开连接请求
					MinecraftClient.getInstance().world.disconnect();
				}
			}
		});
	}

	private void loadHandledTraders() {
		if (dataFile.exists()) {
			try (FileInputStream fis = new FileInputStream(dataFile);
				 ObjectInputStream ois = new ObjectInputStream(fis)) {
				handledTraders.clear();
				handledTraders.addAll((Set<UUID>) ois.readObject());
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveHandledTraders() {
		try (FileOutputStream fos = new FileOutputStream(dataFile);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(handledTraders);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}