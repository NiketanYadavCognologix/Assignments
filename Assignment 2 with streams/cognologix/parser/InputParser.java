package com.cognologix.parser;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.cognologix.mapper.CSVToPojoMapper;

public class InputParser<T> {
    private CSVToPojoMapper mapper;

    public InputParser(CSVToPojoMapper mapper) {
        this.mapper = mapper;
    }
    public List<T> parseArray(String[] input) {
        return Arrays.stream(input)
                .map(v-> v.trim().split(",")) // split each line to array of strings
                .map(values -> (T)mapper.map(values)) // map array of strings to Student Object
                .collect(Collectors.toList());
    }
//    public List<T> parseCSVFile(String inputFilePath)
//    {
//    	 List<T> inputList = new ArrayList<T>();
//
//    	    try{
//
//    	      File inputF = new File(inputFilePath);
//    	      InputStream inputFS = new FileInputStream(inputF);
//    	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
//
//    	      // skip the header of the csv
//    	      inputList = br.lines()
////    	    		  .skip(1)
//    	    		  .map(values -> (T)mapper.map(values))
//    	    		  .collect(Collectors.toList());
//    	      br.close();
//    	    } catch (FileNotFoundException|IOException e) {
//    	      System.out.println("Exception");
//    	    }
//
//    	    return inputList ;
//    			
//    }
}
