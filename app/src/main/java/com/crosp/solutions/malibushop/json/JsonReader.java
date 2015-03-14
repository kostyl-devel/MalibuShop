package com.crosp.solutions.malibushop.json;


import com.crosp.solutions.malibushop.SlideAd;
import com.crosp.solutions.malibushop.utils.TagName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonReader {

	public static List<SlideAd> getHome(JSONObject jsonObject)
			throws JSONException {
		List<SlideAd> SlideAds = new ArrayList<SlideAd>();

		JSONArray jsonArray = jsonObject.getJSONArray(TagName.TAG_PRODUCTS);
		SlideAd SlideAd;
		for (int i = 0; i < jsonArray.length(); i++) {
			SlideAd = new SlideAd();
			JSONObject SlideAdObj = jsonArray.getJSONObject(i);
			SlideAd.setId(SlideAdObj.getInt(TagName.KEY_ID));
			SlideAd.setName(SlideAdObj.getString(TagName.KEY_NAME));
			SlideAd.setImageUrl(SlideAdObj.getString(TagName.KEY_IMAGE_URL));

			SlideAds.add(SlideAd);
		}
		return SlideAds;
	}
}
