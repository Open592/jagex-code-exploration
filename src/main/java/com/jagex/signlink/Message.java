package com.jagex.signlink;

public final class Message {

	// Message Ids
	public static final int CONNECTION_INITIALIZATION_MESSAGE = 1;
	public static final int THREAD_INITIALIZATION_MESSAGE = 2;
	public static final int REVERSE_IP_LOOKUP_MESSAGE = 3;
	public static final int OPEN_URL_STREAM_MESSAGE = 4;
	public static final int GET_FULLSCREEN_DISPLAY_MODES_MESSAGE = 5;
	public static final int ENTER_FULLSCREEN_MODE_MESSAGE = 6;
	public static final int EXIT_FULLSCREEN_MODE_MESSAGE = 7;
	public static final int GET_DECLARED_METHOD_MESSAGE = 8;
	public static final int GET_DECLARED_FIELD_MESSAGE = 9;
	public static final int PERFORM_CLASS_LOADER_NATIVE_LIBRARIES_CLEANUP_MESSAGE = 11;
	public static final int RESOLVE_PREFERENCES_FILE_LOCATION_MESSAGE = 12;
	public static final int CUSTOM_CURSOR_MOUSE_MOVE_MESSAGE = 14;
	public static final int SET_CUSTOM_CURSOR_COMPONENT_MESSAGE = 15;
	public static final int OPEN_URL_IN_BROWSER_MESSAGE = 16;
	public static final int SET_CUSTOM_CURSOR_MESSAGE = 17;
	public static final int GET_SYSTEM_CLIPBOARD_CONTENTS_MESSAGE = 18;
	public static final int SET_SYSTEM_CLIPBOARD_CONTENTS_MESSAGE = 19;
	public static final int LOAD_JAG_MISC_NATIVES_MESSAGE = 20;

	public Message() {
	}

	public Message(int type, int firstIntegerInput, int secondIntegerInput, Object genericInput) {
		this.type = type;
		this.firstIntegerInput = firstIntegerInput;
		this.secondIntegerInput = secondIntegerInput;
		this.genericInput = genericInput;
	}

	public Object genericInput;

	public volatile Object output;

	public Message next;

	public int firstIntegerInput;

	public int secondIntegerInput;

	public int type;

	public volatile int status = 0;
}
