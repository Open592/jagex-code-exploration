package com.jagex.signlink;

public final class Message {

	public Object genericInput;

	public volatile Object output;

	public Message next;

	public int integerInput;

	public int type;

	public volatile int status = 0;
}
