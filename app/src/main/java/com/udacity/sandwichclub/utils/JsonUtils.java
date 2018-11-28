package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwichDetails = new JSONObject(json);
        JSONObject name = sandwichDetails.getJSONObject("name");
        String mainName = name.getString("mainName");

        ArrayList<String> akaArray = new ArrayList<>();
        JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
        for (int i = 0, count = alsoKnownAs.length(); i < count; i++) {
            String item = alsoKnownAs.getString(i);
            akaArray.add(item);
        }

        String placeOfOrigin = sandwichDetails.getString("placeOfOrigin");
        String description = sandwichDetails.getString("description");
        String image = sandwichDetails.getString("image");

        ArrayList<String> ingredientsArray = new ArrayList<>();
        JSONArray ingredients = sandwichDetails.getJSONArray("ingredients");
        for (int i = 0, count = ingredients.length(); i < count; i++) {
            String item = ingredients.getString(i);
            ingredientsArray.add(item);
        }

        return new Sandwich(mainName, akaArray, placeOfOrigin, description, image, ingredientsArray);
    }
}


