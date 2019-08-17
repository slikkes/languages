package bibleshow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TranslationComparatorService {

	// public List<String> getDifferences(String original, String trans) {
	//
	// List<String> origKeys = this.getItems(original);
	// List<String> transKeys = this.getItems(trans);
	//
	// List<String> diffKeys = new ArrayList<String>();
	//
	// origKeys.forEach(item -> {
	// if (transKeys.contains(item)) {
	// diffKeys.add(item);
	// }
	// });
	//
	// return diffKeys;
	// }
	//
	// private List<String> getItems(String langString) {
	//
	// List<String> lines = new
	// ArrayList<String>(Arrays.asList(langString.split("\n")));
	//
	// List<String> keys = new ArrayList<String>();
	// lines.forEach(line -> {
	// String[] props = line.split("=");
	//
	// if (props.length == 2) {
	//
	// keys.add(props[0]);
	// }
	// });
	//
	// return keys;
	//
	// }

	public List<String> getDifferences(String original, String translated) {

		List<Translation> orig = this.getItems(original);
		List<Translation> trans = this.getItems(translated);

		List<String> diffKeys = new ArrayList<String>();

		orig.forEach(item -> {
			boolean exists = trans.stream().filter(t->item.key.equals(t.key)).count() > 0;


			if (!exists) {
				 diffKeys.add(item.getOriginal()); 
				//diffKeys.add(item.key);
			}

		});

		return diffKeys;
	}

	private List<Translation> getItems(String langString) {

		List<String> lines = new ArrayList<String>(Arrays.asList(langString.split("\n")));

		List<Translation> keys = new ArrayList<Translation>();
		lines.forEach(line -> {
			String[] props = line.split("=");

			if (props.length == 2) {

				keys.add(new Translation(props[0], props[1]));
			}
		});

		return keys;

	}
}
