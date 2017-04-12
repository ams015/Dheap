

// ***********************
// NAME: Aman Singh
// ID: A11012283
// LOGIN: cs12sgb
// ***********************

package hw6;
import java.io.*;
import java.util.Scanner;


/**
 * Early Deadline First algortihm
 * schedule based on EDF algorithm
 * @author Aman Singh
 * @version 1.0
 * @date 5/8/16
 */
 
public class EDF {

	/**
	 * Prints when adding, busy with, or done with
	 * @param choice
	 * @param current_time
	 * @param r
	 */
	public static void print(int choice,long current_time, Record r)
	{
		if(choice==1)
			System.out.println( current_time + ": adding " +
					r.toString() );
		else if(choice==2)
			System.out.println( current_time + ": busy with " +
					r.toString() );
		else
			System.out.println( current_time +  ": done with " +
					r.toString( current_time ) );
	}

	/**
	 * Main method 
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length != 1)
		{
			System.err.println("Incorrect number of arguments: "+args.length);
			System.err.println("java hw6.EDF <input-file>");
			System.exit(1); 
		}
		File file = new File(args[0]);
		MyPriorityQueue<Record> queue = new MyPriorityQueue<Record>(10);
		long current_time=0;

		try{
			//your code goes here. 
			
			//choice of whether run or schedule
			String choice;
			
			// the process being done
			String process=null;
			
			//the line into a string
			String theline;
			
			
			Record tmp, newschedule;

			Scanner linescanner = new Scanner(file); 
			
			Scanner scanwords;

			long deadline = 0;
			long duration = 0;  
			long timeNeeded=0;

			//checks if there is a next line in file
			while(linescanner.hasNextLine()){
				//scans the line
				theline = linescanner.nextLine();

				//scans the word
				scanwords = new Scanner(theline);


				//checks if there is a next word
				if(scanwords.hasNext()){
					//becomes the next word
					choice= scanwords.next();


					//if the word is schedule
					if (choice.equals("schedule")) {
						
						//takes out the process,deadline,and duration
						if (scanwords.hasNext()){
							process = scanwords.next();

						}

						if (scanwords.hasNextLong()){
							deadline = scanwords.nextLong();

						}

						if (scanwords.hasNextLong()){
							duration = scanwords.nextLong();

						}

						//creates new record
						newschedule= new Record(process,deadline,duration);


						//stores the record
						queue.add(newschedule);
						print(1,current_time,newschedule);

					}


					//if the word is run
					if (choice.equals("run")) {

						//gets the duration of run
						if (scanwords.hasNextLong()){
							timeNeeded = scanwords.nextLong();

						}


                        //start running
						do{


							tmp = queue.poll();

							print(2,current_time,tmp);

                            
							long time_left= timeNeeded-current_time;
							long tmpduration= tmp.GetDuration();

							if(tmpduration<=time_left){
								current_time= current_time+tmpduration;
								print(0,current_time,tmp);

							}
							else{
								long time =tmpduration- time_left;
								newschedule = new Record(tmp, time);
								queue.add(newschedule);

								current_time = timeNeeded;
								print(1,current_time,newschedule);

							}

						}while((queue.getSize()>0) && (tmp.GetDuration()
								<=timeNeeded-current_time));


						if(timeNeeded - current_time != 0 ){
							if(queue.getSize()>0){

								tmp=queue.poll();

							}
							
							print(2,current_time,tmp);
							
							// create and add new schedule
							newschedule = new Record(tmp, tmp.GetDuration() 
									- (timeNeeded - current_time));
							queue.add(newschedule);
							current_time = timeNeeded;
							print(1,current_time,newschedule);

						}


					}


				}


			}

		}


		catch(FileNotFoundException e)
		{
			System.err.println("Failed to open "+file);
			System.exit(1);
		}

		System.exit(0);

	}

}
