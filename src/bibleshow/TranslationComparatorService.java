package bibleshow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TranslationComparatorService {

	public List<String> getDifferences(String original, String translated) {

		List<Translation> orig = this.getItems(original);
		List<Translation> trans = this.getItems(translated);

		List<String> diffKeys = new ArrayList<String>();

		orig.forEach(item -> {
			boolean exists = trans.stream().filter(t -> item.key.equals(t.key)).count() > 0;

			if (!exists) {
				diffKeys.add(item.getSeparatedWithTab());

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
