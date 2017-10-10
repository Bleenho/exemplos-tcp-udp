package service;

public class MesaSoap {

	public String mesa(String ping) {
		return ping.equalsIgnoreCase("PING")?"Pong":"Mesa de ping pong";
	}
}
