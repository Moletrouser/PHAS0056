package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MidTermExam {

	
	// reads the url data into an array list
	public static ArrayList<String> brFromURL (URL url) throws IOException{
		// initialises the array lists
		ArrayList<String> allData = new ArrayList<String>();
		InputStream is = null;
		try {
			is = url.openStream();
		} catch (IOException e) {
			System.out.println("Error with URL, check URL is formatted correctly. " +e);
			}
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(isr);
		String line = "";
		String cvsSplitBy = ","; // defines the delimiter that the csv is using
		int lineNum = 0;
		while ((line = b.readLine()) != null) { 
			//ignores first line of csv
			 if(lineNum == 0) {
                 lineNum++;
                 continue;
             }
             lineNum++;
			 Scanner sc = new Scanner(line); 
			 sc.useDelimiter(","); // tells the scanner what delimiter to look for
			 while (sc.hasNext()) { //loops while the scanner still has a token on the line given as input
				 String nextString = sc.next();
				 allData.add(nextString); // appends the next string to the array list
			}
		}
		return allData;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		//initialises all the needed arrays
		ArrayList<String> allData = new ArrayList<String>();
		ArrayList<String> onsData1 = new ArrayList<String>();
		ArrayList<String> onsData2 = new ArrayList<String>();
		ArrayList<Integer> panoData= new ArrayList<Integer>();
		ArrayList<String> constituencyData1= new ArrayList<String>();
		ArrayList<String> constituencyData2= new ArrayList<String>();
		ArrayList<String> surnameData = new ArrayList<String>();
		ArrayList<String> firstnameData = new ArrayList<String>();
		ArrayList<String> partyData = new ArrayList<String>();
		ArrayList<String> partyIdentData = new ArrayList<String>();
		ArrayList<Integer> votesData = new ArrayList<Integer>();
		ArrayList<String> regionData = new ArrayList<String>();
		ArrayList<Integer> electorateData= new ArrayList<Integer>();
		
		
		try {
			
			URL url1 = new URL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/results.csv");
			ArrayList<String> allDataResults = brFromURL(url1);
			//System.out.println(allDataResults);
			
			URL url2 = new URL("http://www.hep.ucl.ac.uk/undergrad/0056/exam-data/constituencies.csv");
			ArrayList<String> allDataConstit = brFromURL(url2);
			//System.out.println(allDataConstit);
			
			int i=0;
			int arrayLength1 = allDataResults.size();
			
			// sorts the data into separate array lists
			while(i<arrayLength1) {
				if (i%8 == 0) {
					String temp = allDataResults.get(i);
					onsData1.add(temp);
				}
				if (i%8==1) {
					String temp = allDataResults.get(i);
					Integer tempInt = Integer.parseInt(temp);
					panoData.add(tempInt);
				}
				if (i%8==2) {
					String temp = allDataResults.get(i);
					constituencyData1.add(temp);
				}
				if (i%8 == 3) {
					String temp = allDataResults.get(i);
					surnameData.add(temp);
				}
				if (i%8 == 4) {
					String temp = allDataResults.get(i);
					firstnameData.add(temp);
				}
				if (i%8==5) {
					String temp = allDataResults.get(i);
					partyData.add(temp);	
				}
				if (i%8 == 6) {
					String temp = allDataResults.get(i);
					partyIdentData.add(temp);
				}
				if (i%8 == 7) {
					String temp = allDataResults.get(i);
					Integer tempInt = Integer.parseInt(temp);
					votesData.add(tempInt);
				}				
				
				i++;	
		    }
			
			i=0;
			int arrayLength2 = allDataConstit.size();
			
			// sorts the data into separate array lists
			while(i<arrayLength2) {
				if (i%4 == 0) {
					String temp = allDataConstit.get(i);
					onsData2.add(temp);
				}
				if (i%4 == 1) {
					String temp = allDataConstit.get(i);
					constituencyData2.add(temp);
				}
				if (i%4 == 2) {
					String temp = allDataConstit.get(i);
					regionData.add(temp);
				}
				if (i%4 == 3) {
					String temp = allDataConstit.get(i);
					Integer tempInt = Integer.parseInt(temp);
					electorateData.add(tempInt);
				}
			i++;
			}
			
		  // sums the total number of registered voters across all constituencies
		  double totalElectorate = 0;
		  for(i = 0; i < electorateData.size(); i++) {
			    totalElectorate += electorateData.get(i);
		  }	
		
		  // sums all the valid votes cast in the electiob
		  double totalVotes= 0;
		  for(i = 0; i < votesData.size(); i++) {
			    totalVotes += votesData.get(i);
		  }		
			
		  // finds the candidate who received the most votes
		  String mostVotesSurname = null;
		  String mostVotesFirstName = null;
		  double mostVotes= 0;
		  for(i = 0; i < votesData.size(); i++) {
			    if(votesData.get(i)>mostVotes) {
			    	mostVotes = votesData.get(i);
			    	mostVotesSurname = surnameData.get(i);
			    	mostVotesFirstName = firstnameData.get(i);
			    }
		  }	
		 
		  
		/*  
		  
		// initialising hash maps
		HashMap<Integer, Integer> constituencyVotesMap = new HashMap<Integer, Integer>();
		HashMap<Integer, String> constituencyCandidateMap = new HashMap<Integer, String>();
		HashMap<Integer, String> constituencyNameMap = new HashMap<Integer, String>(); 
		HashMap<Integer, Integer> constituencyTotalVotesMap = new HashMap<Integer, Integer>(); 
		
		
		
		i=0; 
		while(i<panoData.size()) {
			constituencyVotesMap.put(panoData.get(i), votesData.get(i));
			i++;
		}
		
		while(i<panoData.size()) {
			constituencyCandidateMap.put(panoData.get(i), surnameData.get(i));
			i++;
		}
			
		while(i<panoData.size()) {
			constituencyNameMap.put(panoData.get(i), constituencyData1.get(i));
			i++;
		}	
			
		i=0;
		for (Integer key : constituencyVotesMap.keySet()) {
			int votes = constituencyVotesMap.get(i);
			
		}
		
		ArrayList<Integer> totalConsitVotesData= new ArrayList<Integer>();
		
		
		/*
		// summing total votes in each constituency
		// ran out of time so I couldn't finish this
		i=7; // because the smallest PANO number is 7
		int j=0;
		while (j<panoData.size()) {
			if (panoData.get(j) == i) {
				int totalVotesInThisConstit =+ totalVotesInThisConstit(i);
				j++;
			}
				else {
					totalConsitVotesData.add(totalVotesInThisConstit);
					i++;
					
				}
				
		}
		*/
		
		
		
		int numCandidates = surnameData.size();
		double turnout = totalVotes/totalElectorate;
		double turnoutPercent = turnout*100;
		 
		System.out.println("The total number of candidates in the 2017 election was: " +numCandidates);
		System.out.println("The electorate data is: " +electorateData);
		System.out.println("The total number of registered voters was: " +totalElectorate);
		System.out.println("The total number of votes cast was: " +totalVotes);
		System.out.println("The turnout was: " +turnoutPercent +"%");
		System.out.println("The candidate with the most votes was: " +mostVotesFirstName + " " + mostVotesSurname + " with " + mostVotes +" votes");	
		
		//System.out.println("The ONS data is: " +onsData);
		//System.out.println("The PANO data is: " +panoData);
		//System.out.println("The Constituency data1 is: " +constituencyData1);
		//System.out.println("The Surname data is: " +surnameData);
		//System.out.println("The First name data is: " +firstnameData);
		//System.out.println("The Party data is: " +partyData);
		//System.out.println("The Party indentifier data is: " +partyIdentData);
		//System.out.println("The Party valid votes data is: " +votesData);
		
	    }
		
		catch (Exception e) {
					
		}
		
		
	}

}
