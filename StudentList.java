import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String nameList;
	public static void read(){
		try{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			nameList = bufferedReader.readLine();
		}
		catch(Exception e){

		}
	}
	public static void write(String newString){
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", false));
			bufferedWriter.write(newString);
			bufferedWriter.flush();
			bufferedWriter.close();
		}
		catch(Exception e){

		}
	}


	public static void main(String[] args) {

		if(args.length !=1){
			System.out.println(Constant.Invalid);
			System.exit(1);
		}

//		Check arguments
		if(args[0].equals(Constant.namePrint)) {
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			for(String name : names){
				System.out.println(name);
			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].equals(Constant.randomName)){
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			Random random = new Random();
			int randomNumber = random.nextInt(names.length);
			System.out.println(names[randomNumber]);
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.addName)){
			read();
			System.out.println(Constant.loadingData);
			String newString = args[0].substring(1);
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);
			String dateString = nameList+ Constant.comma +newString+Constant.lastUpdate+dateFormat.format(date);
			write(dateString);

			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.query))
		{
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			boolean check = false;
			String newString = args[0].substring(1);
			for(int index = 0; index<names.length ; index++) {
				if(names[index].equals(newString)) {
					System.out.println(Constant.found);
					check = true;
					break;
				}
			}
			if(!check) System.out.println(Constant.countWords);
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains(Constant.countWords))
		{
			System.out.println(Constant.loadingData);
			read();
			String names[] = nameList.split(Constant.comma);
			System.out.println(names.length +Constant.wordsFound);
			System.out.println(Constant.dataLoaded);
		}
		else{
			//System.out.println(Constant.wrongArgument);
		}
	}
}