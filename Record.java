package hw6;

/**
 * Class for record type
 * includes a process, deadline, and duration of the process
 * @author Aman Singh
 *
 */
public class Record implements Comparable<Record> {

	private String process;
	private long deadline; 
	private long duration; 

	// constructor to create a new record
	// given the name of the process,
	// deadline and duration
	/**
	 * Constructor to create a new record
	 * given name of the process,deadline
	 *and duration
	 * @param process
	 * @param deadline
	 * @param duration
	 */
	Record (String process, long deadline, long duration)
	{
		this.process = process;
		this.deadline = deadline;
		this.duration = duration;
	}

	// constructor to create a new record
	// from the esisting record and new
	// duration
	/**
	 * constructor to create a new record
	 * from the existing record and new
	 * duration
	 * @param r
	 * @param duration
	 */
	Record (Record r, long duration)
	{
		this.process=r.process;
		this.deadline=r.deadline;
		this.duration=duration;
	}

	/**
	 * Returns the duration
	 * @return duration
	 */
	public long GetDuration()
	{
		return duration;
	}

	/**
	 * Process to string
	 */
	public String toString()
	{
		return process+" with deadline "+deadline+" and duration "+duration;
	}

	/**
	 * Returns process to string
	 * @param current_time
	 * @return
	 */
	public String toString(long current_time)
	{
		if(current_time > deadline) return process + " (late)";
		return process;
	}
	/**
	 * compares the deadline between two Records
	 * @param compareTo
	 */
	@Override
		public int compareTo(Record o) 
		{

			if(this.deadline> o.deadline)
			{
				return 1;
			}

			if(this.deadline< o.deadline){

				return -1;

			}
			return 0;
			//...complete the method.
		}
}
