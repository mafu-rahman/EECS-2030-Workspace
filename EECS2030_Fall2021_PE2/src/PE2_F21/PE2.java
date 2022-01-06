package PE2_F21;

import java.io.*;
import java.util.*; 

import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Mahfuz Rahman
Student Number: 217847518
Course Section: C
*/

public class PE2 {
	
	public static void main(String[] args) {
		// Remember to remove any code that you may write in the main method, before you submit.
		ArrayList<String> list = (ArrayList<String>) PerformingArt.readFile("music2.txt");
		Music m = new Music("Mahfuz", "Rahman", list);
		m.play();
	} // end of main
} // end of PE2

/**
 * This is the interface class for Art. It inherits the Comparable class.
 * @author MAHFUZ RAHAMAN
 */
interface Art extends Comparable<Art>{
	public void play();
}

/**
 * This is an abstract class
 * @author MAHFUZ RAHAMAN
 *
 */
abstract class PerformingArt implements Art{
	public static int exceptionCode=0;
	
	/**
	 * Default Constructor
	 */
	public PerformingArt() {
	}
	
	/**
	 * This method reads the file, whose name is passed to the method as a string input argument.
	 * @param fileName is the input file.
	 * @return The method returns an arrayList of String, where each string is one line of the given file.
	 */
	public static List<String> readFile(String fileName){
		exceptionCode = 0;
		Scanner in = null;
		ArrayList<String> list = new ArrayList<String>();	// this list will be used to store the input file line by line
		try {
			in = new Scanner(new File(fileName));
			while(in.hasNextLine()) {	// accepting input line by line and storing into the list array
				list.add(in.nextLine());
			}
			in.close();
		}catch (Exception e) {
			exceptionCode = -1;	// if exception occured, exceptionCode is -1
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public abstract void play();
	
	/**
	 * This is the accessor method for getting <code> exceptionCode </code>.
	 * @return It returns the exceptionCode which indicates the state of reding input file.
	 */
	public int getExceptionCode() {
		return exceptionCode;
	}
}

/**
 * This is the Note class. It is known by three properties,
 * the note, the duration in milisecond that the note is played,
 * and the octave in which the note is played.
 * @author MAHFUZ RAHAMAN
 */
class Note extends PerformingArt{
	private int note;
	private int duration;
	private int octave;
	private int exceptionCode;
	
	/**
	 * Default Constructor initialising the attributes to default values.
	 */
	public Note() {
		this.note = 0;
		this.duration = 0;
		this.octave = 0;
		this.exceptionCode = 0;
	}

	/**
	 * Overloaded constructor initialising values according to the input parameters.
	 * @param note is said to be valid if it is between the interval of [0,127].
	 * @param duration is the duration of note in miliseconds.
	 * Can be any positive integer and it should not be a small duration, for example duration = 10 is too quick to let human hear the note.
	 * @param octave sotres the octave of the note. It is valid if it is between the interval [-1,9].
	 */
	public Note(int note, int duration, int octave) {
		this.note = note;
		this.duration = duration;
		this.octave = octave;
		this.exceptionCode = 0;
	}
	
	/**
	 *  This method plays a note in a specific octave with a certain duration.
	 *  It validates the notes at first and may throw an excetion if the note is invalid.
	 *  The exception is handled inside the method.
	 */
	public void play() {
		try {
			this.exceptionCode = 0;	//used for resetting exceptionCode
			this.validate();
		}catch(Exception e) {
			this.exceptionCode = -3;
			System.out.println(e.getMessage());
		}
		
		if(this.exceptionCode == 0) { // if note is valid and no exception is thrown earlier
			try {
				Synthesizer midiSynthesizer = MidiSystem.getSynthesizer();
				midiSynthesizer.open();
				Instrument[] instrument = midiSynthesizer.getDefaultSoundbank().getInstruments();
				midiSynthesizer.loadInstrument(instrument[0]);
				MidiChannel[] midiChannels = midiSynthesizer.getChannels();
				midiChannels[0].noteOn(this.note, 100);
				try {
					Thread.sleep(duration);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				midiChannels[0].noteOff(this.note);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method validates the note based on the octave value according to the octave-note Table.
	 * @throws MismatchException. This method throws MismatchException with “Octave/Note Mismatch” message, in case the octave value does not match the note value.
	 */
	private void validate() throws MismatchException{
		String s = "Octave/Note Mismatch";
		if((octave >= -1 && octave <= 9) && (note >=0 && note <= 127)) {
			if(octave == -1 && !(note >=0 && note <= 11)) throw new MismatchException(s);
			else if(octave == 0 && !(note >=12 && note <= 23)) throw new MismatchException(s);
			else if(octave == 1 && !(note >=24 && note <= 35)) throw new MismatchException(s);
			else if(octave == 2 && !(note >=36 && note <= 47)) throw new MismatchException(s);
			else if(octave == 3 && !(note >=48 && note <= 59)) throw new MismatchException(s);
			else if(octave == 4 && !(note >=60 && note <= 71)) throw new MismatchException(s);
			else if(octave == 5 && !(note >=72 && note <= 83)) throw new MismatchException(s);
			else if(octave == 6 && !(note >=84 && note <= 95)) throw new MismatchException(s);
			else if(octave == 7 && !(note >=96 && note <= 107)) throw new MismatchException(s);
			else if(octave == 8 && !(note >=108 && note <= 119)) throw new MismatchException(s);
			else if(octave == 9 && !(note >=120 && note <= 127)) throw new MismatchException(s);
		}
		else {
			throw new MismatchException(s);
		}
	}
			
	/**
	 * This method compares two notes.
	 * @param art takes an input of an instance of Art. It is then casted to Note type.
	 * The method handles exception incase the input parameter is not of type Note.
	 * @return It returns an integer value. It returns 0 if notes are same. Returns 1 if note is higher than the input note and -1 otherwise.
	 */
	public int compareTo(Art art) {
		try {
			this.exceptionCode = 0;	//used for resetting exceptionCode
			Note n = (Note) art;	// casting object to Note type
			if(this.exceptionCode == 0) {	// if no exception then run
				if(this.note == n.note && this.octave == n.octave) {	// if note and octave are same.
					return 0;
				}
				else {
					return (this.note - n.getNote());
				}
			}
//			this.validate();
//			n.validate();
		}catch(NullPointerException  e) {
			this.exceptionCode = -1;
			System.out.println(e.getMessage());
		}catch(ClassCastException e) {
			this.exceptionCode = -2;
			System.out.println(e.getMessage());
		} 
//		catch (MismatchException e) {
//			this.exceptionCode = -3;
//			System.out.println(e.getMessage());
//		}
		return -1;
	}
	
	/**
	 * It is the accessor method for <code> exceptionCode </code> 
	 * @return It returns the exceptionCode of the object.
	 */
	public int getExceptionCode() {
		return this.exceptionCode;
	}
	
	/**
	 * It is the accessor method for <code> note </code> 
	 * @return It returns the note of the object.
	 */
	public int getNote() {
		return this.note;
	}
	
	/**
	 * It is the accessor method for <code> octave </code> 
	 * @return It returns the octave of the object.
	 */
	public int getOctave() {
		return this.octave;
	}
	
	/**
	 * It is the accessor method for <code> duration </code> 
	 * @return It returns the duration of the object.
	 */
	public int getDuration() {
		return this.duration;
	}
	
	/**
	 * It is the mutator method for <code> note </code> 
	 * @param note is the input parameter for setting the note.
	 */
	public void setNote(int note) {
		this.note = note;
	}
	
	/**
	 * It is the mutator method for <code> octave </code> 
	 * @param octave is the input parameter for setting the octave.
	 */
	public void setOctave(int octave) {
		this.octave = octave;
	}
	
	/**
	 * It is the mutator method for <code> duration </code> 
	 * @param duration is the input parameter for setting the duration.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * It is the mutator method for <code> exceptionCode </code>
	 * @param exceptionCode is the input parameter for exceptionCode.
	 */
	public void setExceptionCode(int exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
}

/**
 * This is the Music class. This class has four instance variables that show the name of the composer of this piece of music,
 * the name of the music itself, an arrayList of all the notes that comprises this music and 
 * exceptionCode that shows the type of the exceptions that are thrown by the methods of this class.
 * @author MAHFUZ RAHAMAN
 */
class Music extends PerformingArt{
	private String composer;
	private String name;
	private ArrayList<Note> score;
	private int exceptionCode;
	
	/**
	 * This is the default constructor.
	 * It initialises all the intance variables to their default values.
	 */
	public Music() {
		this.composer = null;
		this.name = null;
		this.score = new ArrayList<Note>();
		this.exceptionCode = 0;
	}
	
	/**
	 * This is the overloaded constructor. It initialises the instace variables according to the input parameters.
	 * @param composer is the name of the composer.
	 * @param name is the name of the music.
	 * @param notes is an array list of Note objects.
	 */
	public Music(String composer, String name, ArrayList<Note> notes) {
		this.composer = new String(composer);
		this.name = new String(name);
		this.exceptionCode = 0;
		this.setScore(notes); // deep copying ArrayList<Note> notes using setter method.
	}
	
	/**
	 * This is the overloaded constructor. It initialises the instace variables according to the input parameters.
	 * @param composer is the name of the composer.
	 * @param name is the name of the music.
	 * @param notes is a list of String which are notes.
	 */
	public Music(String composer, String name, List<String> notes) {
		this.composer = new String(composer);
		this.name = new String(name);
		this.exceptionCode = 0;
		this.setScore(notes); // deep copying List<String> notes using setter method.
	}
	
	/**
	 * This method plays all the notes that are stored in the ArrayList score.
	 */
	public void play() {
		for(int i=0; i<this.score.size(); i++) {
			this.score.get(i).play();
		}
	}
	
	/**
	 * This method compares two music objects.
	 * @param art takes an input of an instance of Art. It is then casted to Music type.
	 * This method handles excptions incase the input parameter art is not of type Music.
	 * @return It returns zero, if the name and the composer of the music is the same and both the scores are completely the same. 
	 * If not, -1 is returned.
	 */
	public int compareTo(Art art) {
		boolean match = true;
		try {
			this.exceptionCode = 0;	//used for resetting exceptionCode
			Music m = (Music) art;
			if(this.composer.equals(m.getComposer()) && this.name.equals(m.getName()) && this.score.size() == m.score.size()) {
				for(int i=0; i<this.score.size(); i++) {
					match = match && (this.score.get(i).getNote() == m.score.get(i).getNote()) && (this.score.get(i).getDuration() == m.score.get(i).getDuration()) && (this.score.get(i).getOctave() == m.score.get(i).getOctave());
				}
			}
			else
				match = false;
			
		}catch(NullPointerException  e) {
			match = false;
			this.exceptionCode = -1;
			System.out.println(e.getMessage());
		}catch(ClassCastException e) {
			match = false;
			this.exceptionCode = -2;
			System.out.println(e.getMessage());
		}
		
		if(match)
			return 0;
		else
			return -1;
	}
	
	/**
	 * This is the accessor method for <code> composer </code>.
	 * @return It returns the composer for the object.
	 */
	public String getComposer() {
		if(this.composer != null)
			return (new String(this.composer));
		else
			return null;
	}
	
	/**
	 * This is the accessor method for <code> name </code>.
	 * @return It returns the name of the music.
	 */
	public String getName() {
		if(this.composer != null)
			return (new String(this.name));
		else
			return null;
	}

	/**
	 * This is the accessor method for <code> exceptionCode </code>.
	 * @return It returns the exceptionCode of the object.
	 */
	public int getExceptionCode() {
		return this.exceptionCode;
	}
	
	/**
	 * This is the accessor method for <code> score </code>.
	 * @return It returns an ArrayList of Note objects which is the score of the Music.
	 */
	public ArrayList<Note> getScore(){
		ArrayList<Note> scoreCopy = new ArrayList<Note>();
		for(int i=0; i<this.score.size(); i++) {
			scoreCopy.add(new Note(score.get(i).getNote(), score.get(i).getDuration(), score.get(i).getOctave()));
		}
		return scoreCopy;
	}
	
	/**
	 * This is the setter method for <code> composer </code>.
	 * @param It accepts a String for coposer name.
	 */
	public void setComposer(String composer) {
		if(composer != null)
			this.composer = new String(composer);
		else
			this.composer = null;
	}
	
	/**
	 * This is the setter method for <code> name </code>.
	 * @param name is the name of the Music.
	 */
	public void setName(String name) {
		if(name != null)
			this.name = new String(name);
		else
			this.name = null;
	}
	
	/**
	 * This is the setter method for ArrayList <code> score </code>.
	 * @param notes is an ArrayList of Note objects.
	 */
	public void setScore(ArrayList<Note> notes) {
		this.score = new ArrayList<Note>();
		for(int i=0; i<notes.size(); i++) {		// Deep copying.
			this.score.add(new Note(notes.get(i).getNote(), notes.get(i).getDuration(), notes.get(i).getOctave()));
		}
	}
	
	/**
	 * This is the setter method for List <code> score </code>.
	 * @param notes is an List of Strings, where the string contains a note, its duration and octave.
	 */
	public void setScore(List<String> notes) {
		this.score = new ArrayList<Note>();
		
		String s = "";
		int index, index2;
		int note=0, duration=0, octave=0;
		for(int i=0; i<notes.size(); i++) {
			s = notes.get(i);	// string s gets each line from List notes
			
			index = s.indexOf(" ");		// get the index of first occurrence of blank space " ".
			note = Integer.parseInt(s.substring(0, index));		// the first digits till the first blank space are the notes. Converting the substring into integer value.
			
			index2 = s.lastIndexOf(" ");	// index2 is the index of last blank space " ".
			String temp = s.substring(index+1, index2);	// store the substring from first blank space till last blank space which is the duration.
			temp = temp.trim(); // trimming the substring incase there are more than one blank space.
			duration = Integer.parseInt(temp);	// converting the substring to integer value.
			
			octave = Integer.parseInt(s.substring(index2+1)); // The substring from index(index2) of last blank space is the octave.
			
			this.score.add(new Note(note, duration, octave));	// Implementing Composition relationship. Creating new Note objects and storing in score ArrayList. 
		}
	}
	
	/**
	 * It is the mutator method for <code> exceptionCode </code>
	 * @param exceptionCode is the input parameter for exceptionCode.
	 */
	public void setExceptionCode(int exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
}

/**
 * This is the Exception handling class for Octave/Note mismatch.
 * @author MAHFUZ RAHAMAN
 */
class MismatchException extends Exception{
	public MismatchException() {
		super();
	}
	public MismatchException(String s) {
		super(s);
	}
}