package com.austinv11.modules;

import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.modules.IModule;

public class ModuleLoaderPlus implements IModule {
	
	private volatile boolean isEnabled;
	private volatile IDiscordClient client;
	
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
