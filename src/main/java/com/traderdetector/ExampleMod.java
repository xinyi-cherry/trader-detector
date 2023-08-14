package com.traderdetector;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ExampleMod implements ModInitializer {
//	private final Set<UUID> handledTraders = new HashSet<>();
//	private final File dataFile = new File("wandering_traders.dat");
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public void onInitialize() {
//		loadHandledTraders();
//
//		// 注册事件监听器
//		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
//			if (entity instanceof WanderingTraderEntity) {
//				UUID traderUuid = entity.getUuid();
//				if (!handledTraders.contains(traderUuid)) {
//					handledTraders.add(traderUuid);
//					saveHandledTraders();
//					for (ServerPlayerEntity player : world.getPlayers()) {
//						player.networkHandler.disconnect(Text.of("流浪商人来了，快去看看！"));
//					}
//				}
//			}
//		});
	}
//	private void loadHandledTraders() {
//		if (dataFile.exists()) {
//			try (FileInputStream fis = new FileInputStream(dataFile);
//				 ObjectInputStream ois = new ObjectInputStream(fis)) {
//				handledTraders.clear();
//				handledTraders.addAll((Set<UUID>) ois.readObject());
//			} catch (IOException | ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	private void saveHandledTraders() {
//		try (FileOutputStream fos = new FileOutputStream(dataFile);
//			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//			oos.writeObject(handledTraders);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}