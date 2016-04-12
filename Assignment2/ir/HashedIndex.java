///*  
// *   This file is part of the computer assignment for the
// *   Information Retrieval course at KTH.
// * 
// *   First version:  Johan Boye, 2010
// *   Second version: Johan Boye, 2012
// *   Additions: Hedvig Kjellström, 2012-14
// */  
//
//////////possible check indexer insertinto function
//package ir;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Dictionary;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.ListIterator;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
///**
// *   Implements an inverted index as a Hashtable from words to PostingsLists.
// */
//public class HashedIndex implements Index {
//
//    /** The index as a hashtable. */
//    private HashMap<String,PostingsList> index = new HashMap<String,PostingsList>();
//
//    
//    private File termfile;     
//    private ArrayList<String> terms1 = new ArrayList<> ();
//    private Object FileUtils;
//    
//    
//    
//    
//    
//    
//    /**
//     *  Inserts this token in the index.
//     */
//    
//	//
//	//  YOUR CODE HERE
//	//
//    /**
//     * Creates a file for every word and writes their docids and offsets 
//     * @param token
//     * @param docID
//     * @param offset 
//     */
//    public void insert( String token, int docID, int offset ) {
//	System.out.println ("inserting for DocID -> " + docID );
//	try {
//            termfile = new File("terms/"+token);
//
//            if (!terms1.contains(token)) {
//                terms1.add(token);
//                termfile.createNewFile();
//            }
//            FileWriter  fr = new FileWriter (termfile, true);
//            fr.write(docID + " " + offset + "\n");
//            fr.close();
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(HashedIndex.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(HashedIndex.class.getName()).log(Level.SEVERE, null, ex);
//        }
//	
//}
//
//
//    /**
//     *  Returns all the words in the index.
//     */
//    public Iterator<String> getDictionary() {
//	// 
//	//  REPLACE THE STATEMENT BELOW WITH YOUR CODE
//	//
//	//return null;
//         return index.keySet().iterator();
//    }
//
//
//    /**
//     *  Returns the postings for a specific term, or null
//     *  if the term is not in the index.
//     */
//    public PostingsList getPostings( String token ) {
//	// 
//	//  REPLACE THE STATEMENT BELOW WITH YOUR CODE
//	//
//	//return null;
//        //if (index.containsKey(token)){
//            return index.get(token);
//        //}
//        //return null;
//    }
//
//
//    /**
//     *  Searches the index for postings matching the query.
//     */
//     
//   /////////////////////////////////////////////  
//    public PostingsList search( Query query, int queryType, int rankingType, int structureType ) {
//	// 
//	//  REPLACE THE STATEMENT BELOW WITH YOUR CODE
//	//
//	//return null;
//        //LinkedList<String> assorted = new LinkedList<>();
//        //  assorted=Genascterms(query);
//     //   switch (queryType) {
//     // case 0:
//       
//       
//        /*if (!new File("/home/sugandh/Downloads/ir-assignments/doclist.txt").isFile()){
//            System.out.println("Creating Document list...Wait!");
//            //DocListHandle();
//        }
//        else{
//            System.out.println("Doc List Present! Not making...");
//        }*/
//        
//        /**
//         * Check to see if the alphabetical index is present on the disk by searching for azitems.txt
//         * If it is not present then call readtermsdir() to create the index
//         * else do nothing.
//         */
//        if (!new File("/home/sugandh/Downloads/ir-assignments/azitems.txt").isFile()){
//            System.out.println("Making index...Wait!");
//            //MakingPrinter(query);
//            readtermsdir();
//        }
//        else{
//        System.out.println("Index present on disk! Not making...");
//        }
//        
//        
//        /**
//         * Assorted is used to store the query terms in ascending order of the number of docs
//         * the terms appear in, Only used for intersection query for 1.2.
//         */
//        LinkedList<String> assorted = new LinkedList<>();
//        //assorted=Genascterms(query);
//        
//        /**
//         * if-else block for calling the type of query.
//         */
//        if(queryType==Index.INTERSECTION_QUERY)
//            {       
//            return DiskintersectSearch(query);}
//        else if(queryType==Index.RANKED_QUERY)
//            {       
//            return DiskintersectSearch(query);}
//                
//            //return intersectSearch(assorted);}
//        else if(queryType==Index.PHRASE_QUERY)
//            {
//            return DiskphraseSearch(query);}
//            //return phraseSearch(query);}
//        else{
//            return DiskintersectSearch(query);}
//            //return intersectSearch(assorted);}
//            }
//
////private PostingsList intersectSearch(Query q) {
//    
//    /**
//     * Generates the query terms in ascending order of their frequency of occurrence in docs
//     * Only called for intersection search for 1.2
//     * @param q
//     * @return linkedlist ascterms
//     */
//    private LinkedList<String> Genascterms(Query q) {   
//        LinkedList<String> terms = q.copy().terms;
//        int finalsize = terms.size();
//        System.out.println("Searching for " + terms.peekFirst());
//        LinkedList<String> ascterms = new LinkedList<String>();
//        LinkedList<String> temp = new LinkedList<String>();
//        //temp.add("lalal");
//        //System.out.println("size "+temp.size());
//    
//        while(ascterms.size()!=finalsize){
//            System.out.println("enter asc while\n");
//            String minterm = terms.peekFirst();
//            PostingsList l1 = getPostings(terms.removeFirst());
//            System.out.println("minterm " +minterm);
//            String tempterm;
//            //PostingsList l1 = getPostings(terms.removeFirst());
//        
//            int min = l1.size();
//            while (!terms.isEmpty()) {
//		System.out.println("enter TERMS while\n");
//                //  System.out.println("Searching for " + terms.peekFirst() + " among " + index.size());
//                // list = intersect(list.getListEntires(), getPostings(terms.removeFirst()).getListEntires());
//                tempterm = terms.peekFirst();
//                PostingsList temppl = getPostings(terms.removeFirst());
//                if(min > temppl.size()){
//                    temp.add(minterm);
//                    minterm = tempterm;
//                    min = temppl.size();
//                }
//                else{
//                    temp.add(tempterm);
//                }
//            }
//            ascterms.add(minterm);
//            System.out.println("size "+temp.size());
//            if (!temp.isEmpty()) {
//		minterm = temp.peekFirst();
//		PostingsList l2 = getPostings(temp.removeFirst());
//		//l1 = getPostings(temp.removeFirst());
//		min = l2.size();
//		while (!temp.isEmpty()) {
//		tempterm = temp.peekFirst();
//		PostingsList temppl2 = getPostings(temp.removeFirst());
//		if(min > temppl2.size()){
//                	terms.add(minterm);
//			minterm = tempterm;
//			min = temppl2.size();
//			}
//                else{
//                    	terms.add(tempterm);
//                    }
//		}
//		ascterms.add(minterm);
//		}
//            }
//            /*PostingsList ll1 = getPostings(ascterms.removeFirst());
//            if(ascterms.size()>1){
//            PostingsList ll2 = getPostings(ascterms.removeFirst());
//            if(ll1.size()>ll2.size()){
//             ll1 = intersect(ll1, ll2 );
//            }
//            else{
//                ll1 = intersect(ll2,ll1);
//            }
//        
//            //System.out.println("min term "+minterm);
//             }*/
//        return ascterms;
//    }
//
///**
// * Helper function to call intersect() on terms in query
// * @param terms
// * @return linkedlist list
// */
//private PostingsList intersectSearch(LinkedList<String> terms) {
//	//for (int i=0;i<=terms.size();i++){
//	//	System.out.println(terms.get(i));
//	//
//	
//    PostingsList list = getPostings(terms.removeFirst());
//
//    while (!terms.isEmpty()) {
//
//      list = intersect(list, getPostings(terms.removeFirst()));
//    }
//    return list;
//  }
//  
////****NEW
///**
// * Helper function to call phrasequery() on terms in the query
// * @param q
// * @return return linkedlist list
// */
//private PostingsList phraseSearch(Query q) {
//    //System.out.println("q zize"+q.size());
//    LinkedList<String> terms = q.copy().terms;
//    PostingsList list = getPostings(terms.removeFirst());
//    System.out.println("terms zize"+terms.size());
//    while (!terms.isEmpty()) {
//        System.out.println("calling func phrasesear");
//        list = phrasequery(list, getPostings(terms.removeFirst()));
//    }
//    return list;
//}
//  
///**
// * Actual Intersection search for two terms is performed by this function, returns
// * a posting list.
// * @param p1
// * @param p2
// * @return postinglist answer
// */
//private PostingsList intersect(PostingsList p1, PostingsList p2) {
//    PostingsList answer = new PostingsList();
//     
//     int i=0;
//     int j=0;
//     System.out.println("p1 zize"+p1.size());
//     System.out.println("p1 zize"+p2.size());
//     while(i<p1.size() && j<p2.size()){
//         if((p1.get(i).docID) == (p2.get(j).docID)){
//             answer.addListEntry(p1.get(i).docID);
//             System.out.println("doc id"+p1.get(i).docID);
//             i++;
//             j++;
//         }
//         else if(p1.get(i).docID<p2.get(j).docID){
//             i++;
//         }
//         else{
//             j++;
//         }
//     }
//     return answer;
// }
//
///**
// * Actual phrase search for two terms is performed by this function, returns
// * a posting list.
// * @param p1
// * @param p2
// * @return Postinglist answer
// */
//private PostingsList phrasequery(PostingsList p1, PostingsList p2) {
//    PostingsList answer = new PostingsList();
//    System.out.println("inside pquery");
//    int i,j,m,n;
//    i=j=0;
//    while(i<p1.size() && j<p2.size()){
//        /*for(;i<p1.size();i++){
//                System.out.print("docs 1 are \t"+p1.get(i).docID);
//                System.out.println("");
//        }
//        for(;j<p2.size();j++){
//                System.out.print("docs  2 are \t"+p2.get(j).docID);
//        }*/
//        //i=0;j=0;
//        if((p1.get(i).docID) == (p2.get(j).docID)){
//            System.out.println("found doc "+p1.get(i).docID);
//			
//            // PostingsList l = new PostingsList();
//            
//            LinkedList<Integer> pp1 = p1.get(i).getoffsets();
//            LinkedList<Integer> pp2 = p2.get(j).getoffsets();
//            // System.out.println("size 1 "+pp1.size());
//            // System.out.println("size 2 "+pp2.size());
//            m=n=0;
//            int x =0;
//            int y=0;
//            /*for(x=0;x<pp1.size();x++){
//                System.out.print("offsets 1 are \t"+pp1.get(x));
//            }
//            for(y=0;y<pp2.size();y++){
//                System.out.print("offsets  2 are \t"+pp2.get(y));
//            }*/
//            while(m<pp1.size() && n<pp2.size()){
//                System.out.println("iinside loop");
//                System.out.println("pp2 n "+pp2.get(n));
//                System.out.println("pp1 m "+pp1.get(m));
//                if(pp2.get(n)-pp1.get(m)==1){
//                        System.out.println("iinside if");
//                        //bug was here
//                        answer.add(p2.get(j));
//                        m++;
//                        n++;
//                }
//                else if ((pp2.get(n)) > pp1.get(m)) {
//                                m++;
//                        }
//                        else {
//                                n++;
//                        }
//
//            }
//            i++; 
//            j++;
//			
//        }
//            
//        else if (p1.get(i).docID < p2.get(j).docID) {
//           // System.out.println(".docid"+p1.get(i).docID);
//           // System.out.println("Return docid"+p1.get(i).Returndocid());
//            i++;
//        }
//        else {
//            j++;
//        }
//    }
//    return answer;
//    }
//
//
//
//    /**
//     *  No need for cleanup in a HashedIndex.
//     */
//    public void cleanup() {
//    }
//    
//    
//    /**
//     * Decides which file the terms will go to or which file a term is located in
//     * @param s
//     * @return filename
//     */
//    private String GenerateFileName(String s){
//        String fileName = new String();
//        if(s.startsWith("a")||s.startsWith("z")){
//            fileName = "azitems.txt";
//        }
//        else if(s.startsWith("b")||s.startsWith("y")){
//            fileName = "byitems.txt";
//        }
//        else if(s.startsWith("c")||s.startsWith("x")){
//            fileName = "cxitems.txt";
//        }
//        else if(s.startsWith("d")||s.startsWith("w")){
//            fileName = "dwitems.txt";
//        }
//        else if(s.startsWith("e")||s.startsWith("v")){
//            fileName = "evitems.txt";
//        }
//        else if(s.startsWith("f")||s.startsWith("u")){
//            fileName = "fuitems.txt";
//        }
//        else if(s.startsWith("g")||s.startsWith("t")){
//            fileName = "gtitems.txt";
//        }
//        else if(s.startsWith("h")||s.startsWith("s")){
//            fileName = "hsitems.txt";
//        }
//        else if(s.startsWith("i")||s.startsWith("r")){
//            fileName = "iritems.txt";
//        }
//        else if(s.startsWith("j")||s.startsWith("q")){
//            fileName = "jqitems.txt";
//        }
//        else if(s.startsWith("k")||s.startsWith("p")){
//            fileName = "kpitems.txt";
//        }
//        else if(s.startsWith("l")||s.startsWith("o")){
//            fileName = "loitems.txt";
//        }
//        else if(s.startsWith("m")||s.startsWith("n")){
//            fileName = "mnitems.txt";
//        }
//        else{
//            fileName = "everythingelse.txt";
//        }
//        return fileName;
//    }
//    
//    /**
//     * Used in the v1 for diskir
//     * @param q 
//     */
//    private void MakingPrinter( Query q){
//    //To print term+docid+offsets within that doc
//    System.out.println("size "+index.size());
//    Iterator<String> d1 = getDictionary();
//    Iterator<String> d1copy = getDictionary();
//	
//    
//    while(d1.hasNext()){
//	// int ik=0;
//        //System.out.println(" "+d1.toString());
//        // System.out.println(" "+d1.next());
//        PostingsList temp= new PostingsList();
//        //temp = getPostings(d1.next());
//        String d1n=d1.next();
//        temp = getPostings(d1n);
//        for(int xtemp=0;xtemp<temp.size();xtemp++){
//            //System.out.print(" "+d1copy.next()+"   offsets are \t"+temp.get(xtemp).getoffsets().listIterator(0).toString());
//            //System.out.println("");
//            //}
//            //System.out.print(d1n+"\t"+temp.get(xtemp).docID+"\t");
//            CreateFiles(d1n, d1n+"\t"+temp.get(xtemp).docID+"\t");
//            int i =0;
//            while(i<temp.get(xtemp).getoffsets().size()){
//                //System.out.print(temp.get(xtemp).getoffsets().get(i)+" ");
//                CreateFiles(d1n, temp.get(xtemp).getoffsets().get(i)+" ");
//                i++;
//            }
//            System.out.println("");
//            CreateFiles(d1n, "\n");
//				
//	}
//       
//    }
//}
//    
//    /**
//     * Used to create alphabetical (azitems.txt, etc) files and fill them with:
//     * term docid offset1 (offset2) ....
//     * Called by makealphafiles() and MakingPrinter()
//     * @param s1
//     * @param s2 
//     */
//    public void CreateFiles(String s1, String s2) {
//        //s1 - string to create/find the name of the file
//        //s2 - string containing the actual data
//        
//        // The name of the file to open.
//        //int fcount = 0;
//        //int count=0;
//        
//        
//        //String fileName = "temp"+fcount+".txt";
//        String fileName = GenerateFileName(s1);
//        
//        
//        BufferedWriter writer = null;
//        try {
//
//            File logFile = new File(fileName);
//            writer = new BufferedWriter(new FileWriter(fileName,true));
//
//            writer.write(s2);
//            
//            writer.close();
//        }
//        catch(IOException ex) {
//            System.out.println(
//                "Error writing to file '"
//                + fileName + "'");
//            // ex.printStackTrace();
//        }
//    }
//    
//    
//    /*
//    term1, term2 and term3temp are used for the intersection search when index is on disk 
//    */
//    private LinkedList<String> term1 = new LinkedList();
//    //term1 stores the docids for the term
//    private LinkedList<String> term2 = new LinkedList();
//    //term2, if empty, is a clone of term1 otherwise it holds the intersection 
//    //of the current term2 values(previous terms) and term1(cuurent term) 
//    private LinkedList<String> term3temp = new LinkedList();
//    //term3temp is a clone of term2 which is returned
//    
//    /**
//     * Finds the docids for a term or docids for intersection of two terms
//     * @param term
//     * @return term3temp
//     */
//    public LinkedList<String> ReadFromFileIntersect(String term){
//        //LinkedList<String> term1 = new LinkedList();
//        //LinkedList<String> term2 = new LinkedList();
//        String filename = GenerateFileName(term);
//        term1.clear();
//        Scanner sc2 = null;
//        try {
//            sc2 = new Scanner(new File(filename));
//        }   catch (FileNotFoundException e) {
//            e.printStackTrace();  
//        }
//        while (sc2.hasNextLine()) {
//            String[] words = sc2.nextLine().split("\\s");
//        
//            
//            //System.out.println(words[0]);
//            if(words[0].equals(term)){
//                
//                term1.add(words[1]);
//            
//            }
//				
//        }
//        
//        /*for(int i=0;i<term1.size();i++){
//            System.out.println("term1111");
//            System.out.println("term1 item "+term1.get(i));
//        }*/
//        //term3temp=(LinkedList<String>)term1.clone();
//        
//        //tem2=tem1.;
//	//term3temp.retainAll(term1);
//        //for(int i=0;i<term1.size();i++){
//        //    System.out.println("term1 item "+term1.get(i));
//        //}
//        if(term2.isEmpty()){
//            term2=(LinkedList<String>)term1.clone();
//        }
//        else{
//            term2.retainAll(term1);
//        }
//        /*for(int i=0;i<term2.size();i++){
//            System.out.println("term2 item "+term2.get(i));
//        }*/
//        term3temp=(LinkedList<String>)term2.clone();
//        return term3temp;
//    }
//
//    /**
//     * Helper function for calling Readfromfileintersect()
//     * @param q
//     * @return 
//     */
//    private PostingsList DiskintersectSearch(Query q) {
//            //for (int i=0;i<=terms.size();i++){
//        System.out.println("inside disk, query size =  "+q.size());
//            //
//
//        LinkedList<String> terms = q.copy().terms;
//        LinkedList<String> linkedlist = new LinkedList<>();
//
//        PostingsList list = new PostingsList();
//
//        while (!terms.isEmpty()) {
//            System.out.println("inside While");
//            linkedlist = ReadFromFileIntersect(terms.removeFirst());
//        }
//
//        /*for(int i=0;i<linkedlist.size();i++){
//            System.out.println("linked list "+linkedlist.get(i));
//        }*/
//
//
//        while (!term2.isEmpty()) {
//            //System.out.println("dele yayayaya ");
//            term2.removeFirst();
//        }
//        //System.out.println("linked list 2 "+linkedlist.size());
//        /*for(int i=0;i<linkedlist.size();i++){
//
//            System.out.println("linked list 2 "+linkedlist.get(i));
//        }*/
//        //System.out.println("linked list yayayaya ");
//        for (int i = 0; i < linkedlist.size(); i++) {
//            list.addListEntry(Integer.parseInt(linkedlist.get(i)));
//        }
//        /*for (int i=0;i<list.size();i++){
//            System.out.println("post list "+list.get(i).toString());
//        }*/
//        System.out.println("Search finished!");
//        return list;
//      }
//
//    /**
//     * Helper function for calling ReadFromFilePhrase()
//     * @param q
//     * @return 
//     */
//    private PostingsList DiskphraseSearch(Query q) {
//        System.out.println("inside disk, query size = "+q.size());
//            //
//        String first, second;
//        LinkedList<String> terms = q.copy().terms;
//        LinkedList<String> linkedlist = new LinkedList<>();
//
//        PostingsList list = new PostingsList();
//        if(terms.size()==1){
//            linkedlist = ReadFromFileIntersect(terms.removeFirst());
//        }
//
//        else if(terms.size()==2){
//            first = terms.removeFirst();
//            System.out.println(first);
//            second = terms.removeFirst();
//            System.out.println(second);
//            linkedlist = ReadfromFilePhrase(first, second);
//        }
//        else{
//            first = terms.removeFirst();
//            second = terms.removeFirst();
//            ReadfromFilePhrase(first, second);
//            while (!terms.isEmpty()) {
//                first = second;
//                second = terms.removeFirst();
//                linkedlist = ReadfromFilePhrase(first, second);
//            }
//        }
//        for (int i = 0; i < linkedlist.size(); i++) {
//            list.addListEntry(Integer.parseInt(linkedlist.get(i)));
//        }
//        /*for (int i=0;i<list.size();i++){
//            System.out.println("post list "+list.get(i).toString());
//        }*/
//
//        System.out.println("Search finished!");
//        aret.clear();
//        return list;
//    }
//
//    private LinkedList<String> aret = new LinkedList<>();
//    /**
//     * Performs the phrase search when the index(alpha files) is on disk
//     * @param first
//     * @param second
//     * @return 
//     */
//    private LinkedList<String> ReadfromFilePhrase(String first, String second){
//        String filename1 = GenerateFileName(first);
//        String filename2 = GenerateFileName(second);
//        //List<List<String>> fword = new ArrayList<>();
//        //List<List<String>> sword = new ArrayList<>();
//        Map<String, ArrayList<String>> w1 = new HashMap<String, ArrayList<String>>();
//        Map<String, ArrayList<String>> w2 = new HashMap<>();
//        LinkedList<String> atemp = new LinkedList<>();
//        //ArrayList<String> a2 = new ArrayList<>();
//        System.out.println("Calling phrase search disk");
//        //term1.clear();
//        Scanner sc1 = null;
//        try {
//            sc1 = new Scanner(new File(filename1));
//        }   catch (FileNotFoundException e) {
//            e.printStackTrace();  
//        }
//        while (sc1.hasNextLine()) {
//            String[] words = sc1.nextLine().split("\\s");
//        
//            
//            //System.out.println(words[0]);
//            if(words[0].equals(first)){
//                
//                //term1.add(words[1]);
//                int i=2;
//                ArrayList<String> a1= new ArrayList<>();
//                while(i<words.length){
//                    //System.out.println("adding" + words[i]);
//                    a1.add(words[i]);
//                    //System.out.println(a1.get(0));
//                    i++;
//                }
//                //System.out.println("words1"+words[1]);
//                w1.put(words[1],a1);
//                
//            }
//				
//        }
//        /*for(String key:w1.keySet()){
//            System.out.println("print "+key+"\t"+w1.get(key));
//        }*/
//        //System.out.println("w1 "+w1);
//        
//        Scanner sc2 = null;
//        try {
//            sc2 = new Scanner(new File(filename2));
//        }   catch (FileNotFoundException e) {
//            e.printStackTrace();  
//        }
//        while (sc2.hasNextLine()) {
//            String[] words = sc2.nextLine().split("\\s");
//        
//            
//            //System.out.println(words[0]);
//            if(words[0].equals(second)){
//                
//                if(words[0].equals(second)){
//                
//                //term1.add(words[1]);
//                int i=2;
//                ArrayList<String> a2 = new ArrayList<>();
//                while(i<words.length){
//                    //System.out.println("adding" + words[i]);
//                    a2.add(words[i]);
//                    //System.out.println(a2.get(0));
//                    i++;
//                }
//                //System.out.println("words1"+words[1]);
//                w2.put(words[1],a2);
//                
//            }
//				
//        }
//        
//        //for(int ik=0;ik<w1.size();ik++)
//        //    System.out.println(w1.get(ik));
//        }
//        /*for(String key:w2.keySet()){
//            System.out.println("print222 "+key+"\t"+w2.get(key));
//        }*/
//        for(String key1:w1.keySet()){
//            for(String key2:w2.keySet()){
//                if(key1.equals(key2)){
//                    //System.out.println("offset word 2 "+w2);
//                    //System.out.println("offset word 1 "+w1);
//                    int i=0,j=0;
//                    
//                    while(i<w1.get(key1).size() && j<w2.get(key2).size()){
//							
//			    //System.out.println("offset word 2 "+Integer.parseInt(w2.get(key2).get(j)));
//			    //System.out.println("offset word 1 "+Integer.parseInt(w1.get(key1).get(i)));
//                            if(Integer.parseInt(w2.get(key2).get(j))-Integer.parseInt(w1.get(key1).get(i))==1){
//                                //System.out.println("docid 2 "+w2);
//                                //System.out.println("docid 1 "+w1);
//                                //System.out.println("key1 "+key1+" key2 "+key2);
//                                atemp.add(key1);
//                                //System.out.println("atemp "+atemp.size());
//                                i++;
//                                j++;
//                            }
//                            else if(Integer.parseInt(w2.get(key2).get(j))>Integer.parseInt(w1.get(key1).get(i))){
//                                i++;
//                            }
//                            else{
//                                j++;
//                            }
//                        }
//                    
//                }
//            }
//        }
//        //System.out.println("atemp size " +atemp.size());
//        if(aret.size()==0){
//            aret = (LinkedList<String>) atemp.clone();
//            
//        }
//        else{
//            aret.retainAll(atemp);
//        }
//        //System.out.println("aret size " +aret.size());
//        /*for(int i=0;i<aret.size();i++){
//            System.out.println("Aret "+aret.get(i));
//        }*/
//    return aret;
//    }
//    
//    
//    /**
//     * To get the names of docs in the result, Creates the equivalent of index.docIDs so that document names could be retrieved.
//     */
//    public void loadnames(){
//        System.out.println("calling indexhashd");
//       
//        String filename = "/home/sugandh/Downloads/ir-assignments/doclist.txt";
//        Scanner sc2 = null;
//         
//        try {
//            sc2 = new Scanner(new File(filename));
//        }   catch (FileNotFoundException e) {
//            e.printStackTrace();  
//        }
//        while (sc2.hasNextLine()) {
//            String[] words = sc2.nextLine().split("\\s");
//            docIDs.put(words[0], words[1]);
//	}
//    }
//
//    /**
//     * Read each file in the terms directory and create alphabetical files
//     */
//    public void readtermsdir(){
//        ArrayList<PostingsList> narray = new ArrayList<>();
//        File dir = new File("/home/sugandh/Downloads/ir-assignments/terms");
//        File[] directoryListing = dir.listFiles();
//        if (directoryListing != null) {
//            for (File child : directoryListing) {
//                //System.out.println("file "+child);
//                String fname;
//                fname = child.toString();
//                PostingsList ptemp = new PostingsList();
//                Scanner sc2 = null;
//
//                try {
//                sc2 = new Scanner(new File(fname));
//                }   catch (FileNotFoundException e) {
//                e.printStackTrace();  
//                }
//                //creates a postinglist for the term
//                while (sc2.hasNextLine()) {
//
//                    String[] words = sc2.nextLine().split("\\s");
//                    int ip=1;
//                    //System.err.println("words length "+words.length);
//                    while(ip<words.length){
//                    ptemp.addListEntry(Integer.parseInt(words[0]), Integer.parseInt(words[ip]));
//                    ip++;
//                    }
//
//                }
//            //narray holds posting lists for all the terms
//            narray.add(ptemp);
//            makealphafiles(fname, child.getName(), narray);
//            }
//        }
//        else {
//    // Handle the case where dir is not really a directory.
//    // Checking dir.isDirectory() above would not be sufficient
//    // to avoid race conditions with another process that deletes
//    // directories.
//        }
//    }
//
//    
//    /**
//     * Fills the alphabetical files with the words and their docids and offsets
//     * @param fileName
//     * @param child
//     * @param narray 
//     */
//    private void makealphafiles(String fileName, String child, ArrayList<PostingsList> narray){
//       
//	//System.out.println("inside makeaklpha "+child);
//        //for (Iterator<PostingsList> it = narray.iterator(); it.hasNext();) {
//        // PostingsList entry = it.next();
//        while(!narray.isEmpty()){
//        PostingsList entry = narray.get(0);
//        narray.remove(0);
//        for(int xtemp=0;xtemp<entry.size();xtemp++){
//                    //System.out.println("xtem "+xtemp);
//            //System.out.print(" "+d1copy.next()+"   offsets are \t"+temp.get(xtemp).getoffsets().listIterator(0).toString());
//            //System.out.println("entry size "+entry.size());
//            //}
//            //System.out.print(child+"\t"+entry.get(xtemp).docID+"\t");
//            CreateFiles(child, child+"\t"+entry.get(xtemp).docID+"\t");
//            int i =0;
//            while(i<entry.get(xtemp).getoffsets().size()){
//                //System.out.print(entry.get(xtemp).getoffsets().get(i)+" ");
//                CreateFiles(child, entry.get(xtemp).getoffsets().get(i)+" ");
//                i++;
//            }
//            //System.out.println("");
//            CreateFiles(child, "\n");
//                }    
//            }
//            narray.clear();
//           
//    }
//}

/*
 *   This file is part of the computer assignment for the
 *   Information Retrieval course at KTH.
 *
 *   First version:  Johan Boye, 2010
 *   Second version: Johan Boye, 2012
 *   Additions: Hedvig Kjellström, 2012-14
 */


package ir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


/**
 *   Implements an inverted index as a Hashtable from words to PostingsLists.
 */
public class HashedIndex implements Index {

    /** The index as a hashtable. */
    private HashMap<String,PostingsList> index = new HashMap<String,PostingsList>();



    /**
     *  Inserts this token in the index.
     */
    public void insert( String token, int docID, int offset ) {
	//
	//  YOUR CODE HERE
	//

        if (index.containsKey(token)==false) {
    		index.put(token, new PostingsList());
    		//System.out.println("New token********"+token);
    	}
    	index.get(token).addListEntry(docID, offset);
    	//System.out.println("DocID********"+docID+"OFFset**********"+offset);
    }


    /**
     *  Returns all the words in the index.
     */
    public Iterator<String> getDictionary() {
	//
	//  REPLACE THE STATEMENT BELOW WITH YOUR CODE
	//
	//return null;
         return index.keySet().iterator();
    }


    /**
     *  Returns the postings for a specific term, or null
     *  if the term is not in the index.
     */
    public PostingsList getPostings( String token ) {
	//
	//  REPLACE THE STATEMENT BELOW WITH YOUR CODE
	//
	//return null;
        //if (index.containsKey(token)){
            return index.get(token);
        //}
        //return null;
    }


    /**
     *  Searches the index for postings matching the query.
     */

  public PostingsList search( Query query, int queryType, int rankingType, int structureType ) {
	//
	//  REPLACE THE STATEMENT BELOW WITH YOUR CODE
	//
	//return null;
        //LinkedList<String> assorted = new LinkedList<>();
        //  assorted=Genascterms(query);
     //   switch (queryType) {
     // case 0:
     LinkedList<String> assorted = new LinkedList<>();
          assorted=Genascterms(query);
          int mulfortfidfonlt =1;
     if(queryType==Index.INTERSECTION_QUERY)
		{
        return intersectSearch(assorted);}
     else if(queryType==Index.RANKED_QUERY && rankingType == Index.TF_IDF)
            {       
				//return ranked(query);}
            return ranked2(query,mulfortfidfonlt);}
     else if(queryType==Index.RANKED_QUERY && rankingType == Index.PAGERANK){
         return rankedpagerank(query);
     }
    else if(queryType==Index.RANKED_QUERY && rankingType == Index.COMBINATION){
         return rankedcombination(query);}
     else if(queryType==Index.PHRASE_QUERY)
     {
      return phraseSearch(query);}
     else{
        return intersectSearch(assorted);}
     }
  
private PostingsList ranked(Query q){
    LinkedList<String> terms = q.copy().terms;
    ArrayList<PostingsList> termarr = new ArrayList<>();
    int N = docIDs.size();
    System.err.println("N "+N);
    PostingsList retlist = new PostingsList();
   
    
    double Score[] = new double[N];
    double Length[] = new double[N];
    
    //Creating query-terms array list
    for(String t:q.terms){
        termarr.add(getPostings(t));
    }
    
    if(termarr.size()==0){
        return new PostingsList();
    }
    
    for(int i=0;i<N;i++){
        Score[i]=0.0;
    }
        /*PostingsList pl = new PostingsList();
        for (Iterator<PostingsList> it = termarr.iterator(); it.hasNext();) {
            pl = it.next();*/
    for(PostingsList pl:termarr){
            //System.err.println("posting list for query"+pl.Returnlist());
            
            for(PostingsEntry pe:pl.Returnlist()){
                Length[pe.docID] += docLengths.get(String.valueOf(pe.docID));}
    }
    double norm=0.0;
    for(PostingsList pl:termarr){
            //System.err.println("posting list for query"+pl.Returnlist());
            double df = pl.size();
            double idf = Math.log10(N/df);
            System.err.println("df "+df+" idf "+idf);
            for(PostingsEntry pe:pl.Returnlist()){
                double tf =  pe.getoffsets().size();
                //tf = Math.log10(1.0+tf);
                //System.err.println("tf "+tf);
                double tfidf = (tf*idf);
                //System.err.println("tfidf "+tfidf);
                norm += tf*tf;
                Score[pe.docID] += tfidf;
                //double tfidf = (tf*idf)/docLengths.get(String.valueOf(pe.docID));
                
                //Length.add(pe.docID, Math.sqrt(docLengths.get(pe.docID)*docLengths.get(pe.docID)));
                
                //score.add(pe.docID, tfidf);
                //Score[pe.docID] += tfidf;
                //pe.score += tfidf;
                //Length[pe.docID] += Math.pow(pe.getoffsets().size(), 2.0);
            }   
            
        }
        norm = Math.sqrt(norm);
    for(PostingsList pl:termarr){
        for(PostingsEntry pe:pl.Returnlist()){
           
				 //System.err.println("score bb "+Score[pe.docID]);
                Score[pe.docID]=Score[pe.docID]/Length[pe.docID];
				//Score[pe.docID]=Score[pe.docID]/norm;
				//Score[pe.docID]=Score[pe.docID]/Math.sqrt(Length[pe.docID]);
            pe.score+=Score[pe.docID];
            System.err.println("score 1"+pe.score);
        }
    }
    
    HashMap<Integer, PostingsEntry> entries = new HashMap<Integer, PostingsEntry>();
        for (Iterator<String> t = terms.iterator(); t.hasNext(); ){
        String term = t.next();
        for (ListIterator<PostingsEntry> it = getPostings(term).getListEntires();
             it.hasNext();) {
          PostingsEntry e = it.next();
          if (!entries.containsKey(e.docID)) {
            entries.put(e.docID, new PostingsEntry(e.docID));
          }
          entries.get(e.docID).score  = e.score;
            System.err.println("score "+entries.get(e.docID).score);
        }
      }
      PostingsList tmp = new PostingsList();
      tmp.list.addAll(entries.values());
      Collections.sort(tmp.list);
      
      for(PostingsList pl:termarr){
        for(PostingsEntry pe:pl.Returnlist()){
            pe.score = 0;
            
        }
    }
      return tmp;
    
    
    
        
}
  
public void weights(int N, ArrayList<PostingsList> termarr){
    double[] Length = new double[N];
    for (Iterator<PostingsList> it = termarr.iterator(); it.hasNext();) {
      PostingsList p = it.next();
      //System.out.println("p "+p.Returnlist());
      double df = p.size();
      double idf = Math.log10(N/df);
      //System.out.println("p idf "+idf);
      for (ListIterator<PostingsEntry> it2 = p.getListEntires(); it2.hasNext();) {
        PostingsEntry e = it2.next();
        Length[e.docID] = e.getoffsets().size()*e.getoffsets().size()*idf*idf;
      }
    }
    for (int i = 0; i < N; i++) {
      if (Length[i] > 0) {
        Length[i] = Math.sqrt(Length[i]);
      }
    }
    for (Iterator<PostingsList> it = termarr.iterator(); it.hasNext();) {
      PostingsList p = it.next();
      double df=p.size();
      double idf = Math.log10(N/df);
      
      for (ListIterator<PostingsEntry> it2 = p.getListEntires(); it2.hasNext();) {
        PostingsEntry e = it2.next();
        double tf = Math.log10(1.0 +e.getoffsets().size());
        e.score = (tf*idf)/docLengths.get(String.valueOf(e.docID));
      }
    }
}    

private PostingsList ranked2(Query q, int multiplier){
    //weights(docLengths.size());
    LinkedList<String> terms = q.copy().terms;
    ArrayList<PostingsList> termarr = new ArrayList<>();
    for(String t:q.terms){
        termarr.add(getPostings(t));
    }
    weights(docLengths.size(),termarr);
    if(terms.size()==0){
        return new PostingsList();
    }
    
    HashMap<String, Integer> queryTerms = new HashMap<String, Integer>();
      for ( int i = 0; i < terms.size(); i++ ) {
        String term = q.terms.get(i);
        if (queryTerms.containsKey(term)){
          queryTerms.put(term, queryTerms.get(term)+1);
        } else {
          queryTerms.put(term, 1);
        }
      }
      double queryNorm = 0;
      for (Iterator<String> t = queryTerms.keySet().iterator(); t.hasNext(); ){
        String term = t.next();
        queryNorm += Math.pow(queryTerms.get(term),2.0);
      }
      queryNorm = Math.sqrt(queryNorm);
      
      HashMap<Integer, PostingsEntry> entries = new HashMap<Integer, PostingsEntry>();
      for (Iterator<String> t = queryTerms.keySet().iterator(); t.hasNext(); ){
        String term = t.next();
        for (ListIterator<PostingsEntry> it = getPostings(term).getListEntires();
             it.hasNext();) {
          PostingsEntry e = it.next();
          if (!entries.containsKey(e.docID)) {
            entries.put(e.docID, new PostingsEntry(e.docID));
          }
            entries.get(e.docID).score += e.score*multiplier*(queryTerms.get(term)/queryNorm);
            System.err.println("score "+entries.get(e.docID).score);
        }
      }
      PostingsList tmp = new PostingsList();
      tmp.list.addAll(entries.values());
      Collections.sort(tmp.list);
      return tmp;
    
    
    //return null;
}


//private PostingsList intersectSearch(Query q) {
private LinkedList<String> Genascterms(Query q) {
    LinkedList<String> terms = q.copy().terms;
    int finalsize = terms.size();
    System.out.println("Searching for " + terms.peekFirst() + " among " + index.size());
    LinkedList<String> ascterms = new LinkedList<String>();
    LinkedList<String> temp = new LinkedList<String>();
    //temp.add("lalal");
    //System.out.println("size "+temp.size());

    while(ascterms.size()!=finalsize){
		System.out.println("enter asc while\n");
        String minterm = terms.peekFirst();
        PostingsList l1 = getPostings(terms.removeFirst());
        System.out.println("minterm " +minterm);
        String tempterm;
	  //PostingsList l1 = getPostings(terms.removeFirst());

        int min = l1.size();
        while (!terms.isEmpty()) {
			System.out.println("enter TERMS while\n");
      //  System.out.println("Searching for " + terms.peekFirst() + " among " + index.size());
     // list = intersect(list.getListEntires(), getPostings(terms.removeFirst()).getListEntires());
            tempterm = terms.peekFirst();
            PostingsList temppl = getPostings(terms.removeFirst());
            if(min > temppl.size()){
                temp.add(minterm);
                minterm = tempterm;
                min = temppl.size();
            }
            else{
                temp.add(tempterm);
            }
        }
        ascterms.add(minterm);

        System.out.println("size "+temp.size());
        if (!temp.isEmpty()) {
			minterm = temp.peekFirst();
			PostingsList l2 = getPostings(temp.removeFirst());
			//l1 = getPostings(temp.removeFirst());
			min = l2.size();
			while (!temp.isEmpty()) {
				tempterm = temp.peekFirst();
				PostingsList temppl2 = getPostings(temp.removeFirst());
				if(min > temppl2.size()){
					terms.add(minterm);
					minterm = tempterm;
					min = temppl2.size();
				}
				else{
					terms.add(tempterm);
				}
			}
			ascterms.add(minterm);
		}
	}
        /*PostingsList ll1 = getPostings(ascterms.removeFirst());
	if(ascterms.size()>1){

            PostingsList ll2 = getPostings(ascterms.removeFirst());
            if(ll1.size()>ll2.size()){
             ll1 = intersect(ll1, ll2 );
            }
            else{
                ll1 = intersect(ll2,ll1);
            }

    //System.out.println("min term "+minterm);

 }*/
        return ascterms;
}

private PostingsList intersectSearch(LinkedList<String> terms) {
	//for (int i=0;i<=terms.size();i++){
	//	System.out.println(terms.get(i));
	//


    PostingsList list = getPostings(terms.removeFirst());

    while (!terms.isEmpty()) {

      list = intersect(list, getPostings(terms.removeFirst()));
    }
    return list;
  }

//****NEW
private PostingsList phraseSearch(Query q) {
	//System.out.println("here 1");
	System.out.println("size "+index.size());
	Iterator<String> d1 = getDictionary();
	Iterator<String> d1copy = getDictionary();

  /* while(d1.hasNext()){
	  // int ik=0;
      //System.out.println(" "+d1.toString());
      // System.out.println(" "+d1.next());
       PostingsList temp= new PostingsList();
       temp = getPostings(d1.next());
       for(int xtemp=0;xtemp!=temp.size();xtemp++){
				System.out.print(" "+d1copy.next()+"   offsets are \t"+temp.get(xtemp).getoffsets());
				System.out.println("");
			}

   }*/

	//System.out.println("q zize"+q.size());
    LinkedList<String> terms = q.copy().terms;
    PostingsList list = getPostings(terms.removeFirst());
	System.out.println("terms zize"+terms.size());
    while (!terms.isEmpty()) {
		System.out.println("calling func phrasesear");
      list = phrasequery(list, getPostings(terms.removeFirst()));
    }
    return list;
  }


private PostingsList intersect(PostingsList p1, PostingsList p2) {
    PostingsList answer = new PostingsList();

     int i=0;
     int j=0;
     System.out.println("p1 zize"+p1.size());
     System.out.println("p1 zize"+p2.size());
     while(i<p1.size() && j<p2.size()){
         if((p1.get(i).docID) == (p2.get(j).docID)){
             answer.addListEntry(p1.get(i).docID);
             System.out.println("doc id"+p1.get(i).docID);
             i++;
             j++;
         }
         else if(p1.get(i).docID<p2.get(j).docID){
             i++;
         }
         else{
             j++;
         }
     }
     return answer;
 }

private PostingsList phrasequery(PostingsList p1, PostingsList p2) {
	  PostingsList answer = new PostingsList();
    System.out.println("inside pquery");
    int i,j,m,n;
    i=j=0;
    while(i<p1.size() && j<p2.size()){
	/*	for(;i<p1.size();i++){
				System.out.print("docs 1 are \t"+p1.get(i).docID);
				System.out.println("");
			}
			for(;j<p2.size();j++){
				System.out.print("docs  2 are \t"+p2.get(j).docID);
			}*/
			//i=0;j=0;
        if((p1.get(i).docID) == (p2.get(j).docID)){
			System.out.println("found doc "+p1.get(i).docID);

           // PostingsList l = new PostingsList();

            LinkedList<Integer> pp1 = p1.get(i).getoffsets();
            LinkedList<Integer> pp2 = p2.get(j).getoffsets();
           // System.out.println("size 1 "+pp1.size());
           // System.out.println("size 2 "+pp2.size());
            m=n=0;
            int x =0;
            int y=0;
            /*for(x=0;x<pp1.size();x++){
				System.out.print("offsets 1 are \t"+pp1.get(x));
			}
			for(y=0;y<pp2.size();y++){
				System.out.print("offsets  2 are \t"+pp2.get(y));
			}*/
            while(m<pp1.size() && n<pp2.size()){
					System.out.println("iinside loop");
					System.out.println("pp2 n "+pp2.get(n));
					System.out.println("pp1 m "+pp1.get(m));
					if(pp2.get(n)-pp1.get(m)==1){
						System.out.println("iinside if");
						answer.add(p2.get(j));
						m++;
						n++;
					}
					else if ((pp2.get(n)) > pp1.get(m)) {
							m++;
						}
						else {
							n++;
						}

				}
                i++;
                j++;

            }

            else if (p1.get(i).docID < p2.get(j).docID) {
               // System.out.println(".docid"+p1.get(i).docID);
               // System.out.println("Return docid"+p1.get(i).Returndocid());
                i++;
            }
            else {
                j++;
            }
        }
        return answer;
        }

private PostingsList rankedpagerank(Query q){
       LinkedList<String> terms = q.copy().terms;
    ArrayList<PostingsList> termarr = new ArrayList<>();
    int N = docIDs.size();
    
    PostingsList retlist = new PostingsList();
   
    
    double Score[] = new double[N];
    double Length[] = new double[N];
    
    //Creating query-terms array list
    for(String t:q.terms){
        termarr.add(getPostings(t));
    }
    
    if(termarr.size()==0){
        return new PostingsList();
    }
    
    for(int i=0;i<N;i++){
        Score[i]=0.0;
    }
    for(PostingsList pl:termarr){
            //System.err.println("posting list for query"+pl.Returnlist());
            
            for(PostingsEntry pe:pl.Returnlist()){
                Length[pe.docID] = docLengths.get(String.valueOf(pe.docID));}
    }
    double norm=0.0;
    Scanner sc1 = null;
        try {
            sc1 = new Scanner(new File("/home/sugandh/Downloads/Assignment2/ir/pagerank/SortedNames.txt"));
        }   catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
    Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("/home/sugandh/Downloads/Assignment2/ir/pagerank/doclist.txt"));
        }   catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
    HashMap<String, Double> prscore = new HashMap<>();
    while (sc1.hasNextLine()) {
                String[] words = sc1.nextLine().split("\\s");
                prscore.put(words[0], Double.parseDouble(words[1]));
    }
    
    for(PostingsList pl:termarr){
        for(PostingsEntry pe:pl.Returnlist()){
            for(String key: prscore.keySet()){    
               // System.err.println(docIDs.get(String.valueOf(pe.docID))+"\t"+key);
                if (docIDs.get(String.valueOf(pe.docID)).equals(key)){
					 //System.err.println("Found******************************************************************");
                    Score[pe.docID] = prscore.get(key);
                }
                
                
            }   
            
        }
    }
    
    for(PostingsList pl:termarr){
        for(PostingsEntry pe:pl.Returnlist()){
            pe.score = Score[pe.docID];
            System.err.println("score 1 "+pe.score);
        }
    }
    HashMap<Integer, PostingsEntry> entries = new HashMap<Integer, PostingsEntry>();
        for (Iterator<String> t = terms.iterator(); t.hasNext(); ){
        String term = t.next();
        for (ListIterator<PostingsEntry> it = getPostings(term).getListEntires();
             it.hasNext();) {
          PostingsEntry e = it.next();
          if (!entries.containsKey(e.docID)) {
            entries.put(e.docID, new PostingsEntry(e.docID));
          }
            entries.get(e.docID).score = e.score;
            System.err.println("score "+entries.get(e.docID).score);
        }
      }
      PostingsList tmp = new PostingsList();
      tmp.list.addAll(entries.values());
      Collections.sort(tmp.list);
      return tmp;
}

private PostingsList rankedcombination(Query q){
   int mulforcombtfidf = 10;
   int mulforpr = 100;
   ranked2(q,mulforcombtfidf);
   LinkedList<String> terms = q.copy().terms;
    ArrayList<PostingsList> termarr = new ArrayList<>();
    int N = docIDs.size();
    
    PostingsList retlist = new PostingsList();
   
    
    double Score[] = new double[N];
    double Length[] = new double[N];
    
    //Creating query-terms array list
    for(String t:q.terms){
        termarr.add(getPostings(t));
    }
    
    if(termarr.size()==0){
        return new PostingsList();
    }
    
    for(int i=0;i<N;i++){
        Score[i]=0.0;
    }
    for(PostingsList pl:termarr){
            //System.err.println("posting list for query"+pl.Returnlist());
            
            for(PostingsEntry pe:pl.Returnlist()){
                Length[pe.docID] = docLengths.get(String.valueOf(pe.docID));}
    }
    double norm=0.0;
    Scanner sc1 = null;
        try {
            sc1 = new Scanner(new File("/home/sugandh/Downloads/Assignment2/ir/pagerank/SortedNames.txt"));
        }   catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
    Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File("/home/sugandh/Downloads/Assignment2/ir/pagerank/doclist.txt"));
        }   catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
    HashMap<String, Double> prscore = new HashMap<>();
    while (sc1.hasNextLine()) {
                String[] words = sc1.nextLine().split("\\s");
                prscore.put(words[0], Double.parseDouble(words[1]));
    }
    
    for(PostingsList pl:termarr){
        for(PostingsEntry pe:pl.Returnlist()){
            for(String key: prscore.keySet()){    
               // System.err.println(docIDs.get(String.valueOf(pe.docID))+"\t"+key);
                if (docIDs.get(String.valueOf(pe.docID)).equals(key)){
					 //System.err.println("Found******************************************************************");
                    Score[pe.docID] = prscore.get(key);
                }
                
                
            }   
            
        }
    }
    
    for(PostingsList pl:termarr){
        for(PostingsEntry pe:pl.Returnlist()){
            pe.score += Score[pe.docID]*mulforpr;
            System.err.println("score 1 "+pe.score);
        }
    }
    HashMap<Integer, PostingsEntry> entries = new HashMap<Integer, PostingsEntry>();
        for (Iterator<String> t = terms.iterator(); t.hasNext(); ){
        String term = t.next();
        for (ListIterator<PostingsEntry> it = getPostings(term).getListEntires();
             it.hasNext();) {
          PostingsEntry e = it.next();
          if (!entries.containsKey(e.docID)) {
            entries.put(e.docID, new PostingsEntry(e.docID));
          }
            entries.get(e.docID).score = e.score/(mulforcombtfidf+mulforpr);
            System.err.println("score "+entries.get(e.docID).score);
        }
      }
      PostingsList tmp = new PostingsList();
      tmp.list.addAll(entries.values());
      
      for(PostingsList pl:termarr){
        for(PostingsEntry pe:pl.Returnlist()){
            pe.score = 0;
            
        }
    }
    
      Collections.sort(tmp.list);
      return tmp;
    
   
}
    /**
     *  No need for cleanup in a HashedIndex.
     */
    public void cleanup() {
    }
}
