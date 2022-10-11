package com.cognologix.services;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.cognologix.model.LibraryVersion;

public class libraryVrsionCalculatorService {

	List<LibraryVersion> products;

	public libraryVrsionCalculatorService(List<LibraryVersion> productsList) {
		this.products = productsList;
	}

	public Set<String> getLetestVersionLibrary() {
		Map<String, LibraryVersion> letestLibraryVersion = products.stream()
				.collect(groupingBy(library -> library.getLibraryName(),
						collectingAndThen(maxBy(comparingInt(c -> c.getLibraryVersion())), Optional::get)));

		return getOutDatedSoftware(letestLibraryVersion);
	}

	private Set<String> getOutDatedSoftware(Map<String, LibraryVersion> letestLibraryVersion) {

		return products
				.stream().filter(product -> product.getLibraryVersion() < letestLibraryVersion
						.get(product.getLibraryName()).getLibraryVersion())
				.map(LibraryVersion::getProductName).collect(Collectors.toSet());

	}

}
