package com.austinv11.modules;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.Discord4J;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.modules.IModule;
import sx.blah.discord.modules.ModuleLoader;

import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Collectors;

public class ModuleLoaderPlus implements IModule {
	
	private volatile boolean isEnabled;
	private volatile IDiscordClient client;
	private static final Logger logger = LoggerFactory.getLogger("ModuleLoader+");
	
	static {
		Reflections reflections = new Reflections(Discord4J.class.getClassLoader());
		Set<Class<? extends IModule>> modules = reflections.getSubTypesOf(IModule.class);
		Set<Class<? extends IModule>> filteredModules =  modules.stream()
																.filter(clazz -> 
																		!Modifier.isAbstract(clazz.getModifiers()) 
																		&& !Modifier.isInterface(clazz.getModifiers())
																		&& !ModuleLoader.getModules().contains(clazz))
																.collect(Collectors.toSet());
		logger.info("{} internal modules located, loading them...", filteredModules.size());
		filteredModules.forEach(ModuleLoader::addModuleClass);
	}
	
	@Override
	public boolean enable(IDiscordClient client) {
		this.client = client;
		return isEnabled = true;
	}
	
	@Override
	public void disable() {
		isEnabled = false;
	}
	
	@Override
	public String getName() {
		return "ModuleLoader+";
	}
	
	@Override
	public String getAuthor() {
		return "austinv11";
	}
	
	@Override
	public String getVersion() {
		return "1.0.0";
	}
	
	@Override
	public String getMinimumDiscord4JVersion() {
		return "2.5.0-SNAPSHOT";
	}
}
