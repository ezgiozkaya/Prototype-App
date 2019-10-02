package com.ezgiozkaya.prototypeApp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.ezgiozkaya.prototypeApp.model.Subscriber;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class Util {

	public static List<Subscriber> getSubscribersFromJson(String path) {

		Gson gson = new Gson();
		JsonReader reader;
		List<Subscriber> subscribers = new ArrayList<>();
		try {

			Type TYPE = new TypeToken<List<Subscriber>>() {
			}.getType();

			reader = new JsonReader(new FileReader(path));
			subscribers = gson.fromJson(reader, TYPE);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return subscribers == null ? new ArrayList<Subscriber>() : subscribers;
	}

	public static void saveSubscribers(String path, List<Subscriber> subscribers) {

		try {
			Type listType = new TypeToken<List<Subscriber>>() {
			}.getType();

			Gson gson = new Gson();
			String json = gson.toJson(subscribers, listType);

			FileWriter fileWriter = new FileWriter(path);
			fileWriter.write(json);
			fileWriter.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
