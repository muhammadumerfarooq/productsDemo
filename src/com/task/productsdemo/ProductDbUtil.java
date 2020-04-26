package com.task.productsdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;

public class ProductDbUtil {

	public List<Product> getProducts(String filename) {

		return readProductsFromCSV(filename);

	}

	private static List<Product> readProductsFromCSV(String fileName) {

		List<Product> products = new ArrayList<Product>();

		
		try (CSVReader reader =new CSVReader(new FileReader(fileName))){
		
			String[] line;
			line = reader.readNext();
			while ((line = reader.readNext()) != null) {

			
				Product product = createProduct(line);
				// adding product into ArrayList
				products.add(product);

			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return products;
	}

	private static Product createProduct(String[] metadata) {

		String contractplansegcompl = metadata[0];
		String contract = metadata[1];
		String brandname = metadata[2];
		String planname = metadata[3];
		String state = metadata[4];
		String stateabbreviation = metadata[5];
		String producttype = metadata[6];


		// create and return book of this metadata
		return new Product(contractplansegcompl, contract, brandname, planname, state, stateabbreviation, producttype);

	}

}
