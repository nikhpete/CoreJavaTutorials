package com.nick.LineBreak;

import java.util.Optional;

public class LineBreakDemo {

	public static void main(String[] args) {
		lineBreakMethod(Optional.ofNullable("My name i Nikhil"), 17);
	}

	public static void lineBreakMethod(Optional<String> paraOpt, int limit) {
		paraOpt.ifPresent( para -> {

			String [] splitPara = para.split(" ");

			StringBuffer newString = new StringBuffer();
			int lineCounter = 0;

			for(String splitValue: splitPara) {
				if(splitValue.length() > limit) {
					int firstIndex = 0, lastIndex = limit;
					String sep = "\n";
					while(firstIndex < splitValue.length()){
						newString.replace(0, newString.length(), newString 
								+ sep 
								+ splitValue.substring(firstIndex, lastIndex));
						firstIndex = lastIndex;
						lastIndex = (firstIndex + limit) < splitValue.length()? firstIndex + limit : splitValue.length();
					}
					lineCounter = lastIndex+1 - firstIndex;
				}else if(lineCounter + splitValue.length() > limit) {
					newString.replace(0, newString.length(), newString + "\n" + splitValue);
					lineCounter = splitValue.length();
				}else {
					newString.replace(0, newString.length(), newString + (lineCounter == 0? "": " ") + splitValue);
					lineCounter += splitValue.length() + 1;
				}
			}

			System.out.println(newString);
		});
	}

}
