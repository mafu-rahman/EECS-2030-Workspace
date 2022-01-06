package PE2_F21;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.*;

class PE2_tester4 {
	@Test //1 point  --include
	void testNoteConstructor0() {
		Note note1 = new Note(); 
		boolean actual = ((note1.getExceptionCode() ==  0 && note1.getNote() == 0 && note1.getOctave() == 0 && note1.getDuration() == 0) ? true : false);
		assertEquals(true, actual, "Note's default constructors or getter methods are not properly implemented!");
	}

	@Test //5 points
	void testNoteConstructor1() {
		Note note1 = new Note(60, 100, 4); 
		boolean actual = ((note1.getExceptionCode() ==  0 && note1.getNote() == 60 && note1.getOctave() == 4 && note1.getDuration() == 100) ? true : false);
		assertEquals(true, actual, "Note's constructors or getter methods are not properly implemented!");
	}


	@Test // 1 point --include
	void testNoteCompareTo1() {
		Note note1 = new Note(60, 100, 4); 
		Note note2 = new Note(60, 100, 4); 
		int ret = note1.compareTo(note2); 
		boolean actual = (ret == 0? true : false) && note1.getExceptionCode() == 0; 
		assertEquals(true, actual, "Note's compareTo does not work as expected and/or getExceptionCode is not set properly");
	}

	@Test // 1 point
	void testNoteCompareTo2() {
		Note note1 = new Note(60, 100, 4); 
		Note note2 = new Note(50, 100, 4); 
		int ret = note1.compareTo(note2); 
		boolean actual = (ret == 10? true : false) && note1.getExceptionCode() == 0; 
		assertEquals(true, actual, "Note's compareTo does not work as expected and/or getExceptionCode is not set properly");
	}
	
	@Test // 1 point
	void testNoteCompareTo3() {
		Note note1 = new Note(60, 100, 4); 
		Note note2 = new Note(50, 100, 4); 
		int ret = note2.compareTo(note1); 
		boolean actual = (ret == -10? true : false) && note1.getExceptionCode() == 0; 
		assertEquals(true, actual, "Note's compareTo does not work as expected and/or getExceptionCode is not set properly");
	}
	
	@Test // 1 point --include
	void testNoteCompareTo4() {
		Note note1 = new Note(60, 100, 4); 
		Music note2 = new Music(); 
		int ret = note1.compareTo(note2); 
		int actual = note1.getExceptionCode();
		assertEquals(-2, actual, "getExceptionCode is not set properly for incompatible objects");
	}
	
	@Test // 1 point
	void testNoteCompareTo5() {
		Note note1 = new Note(60, 100, 4); 
		int ret = note1.compareTo(null); 
		int actual = note1.getExceptionCode();
		assertEquals(-1, actual, "getExceptionCode is not set properly for null objects");
	}
	
	@Test // 1 point  -- include
	void testValidate_1() {
		Note note1 = new Note(-3, 100, -1); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave -1");
	}
	@Test // 1 point
	void testValidate0() {
		Note note1 = new Note(40, 100, 0); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 0");
	}
	@Test // 1 point
	void testValidate1() {
		Note note1 = new Note(50, 100, 1); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 1");
	}
	@Test // 1 point
	void testValidate2() {
		Note note1 = new Note(60, 100, 2); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 2");
	}

	@Test // 1 point
	void testValidate3() {
		Note note1 = new Note(70, 100, 3); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 3");
	}
	@Test // 1 point
	void testValidate4() {
		Note note1 = new Note(80, 100, 4); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 4");
	}
	@Test // 1 point
	void testValidate5() {
		Note note1 = new Note(90, 100, 5); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 5");
	}
	@Test // 1 point
	void testValidate6() {
		Note note1 = new Note(100, 100, 6); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 6");
	}
	@Test // 1 point
	void testValidate7() {
		Note note1 = new Note(110, 100, 7); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 7");
	}
	@Test // 1 point
	void testValidate8() {
		Note note1 = new Note(125, 100, 8); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 8");
		note1 = new Note(130, 100, 9); 
		note1.play();
		actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave 9");
	}

	// This tester checks if validateNote throws an exception. However, it does not check the  type of exception.
	 @Test //-- include
     public void testValidateNote1() {
		 Note note = new Note(70, 1000, 9);
		 try {
			 Method method = Note.class.getDeclaredMethod("validateNote", null);
			 method.setAccessible(true);
			 assertThrows(InvocationTargetException.class, ()-> method.invoke(note));
		 }
		 catch (Exception e) {		
			 System.out.println("error");
		 }
     }	

		// This tester checks if validateNote throws an exception. However, it does not check the type of exception.
	 @Test
     public void testValidateNote2() {
		 Note note = new Note();
		 try {
			 Method method = Note.class.getDeclaredMethod("validateNote", null);
			 method.setAccessible(true);
			 assertThrows(InvocationTargetException.class, ()-> method.invoke(note));
		 }
		 catch (Exception e) {		
			 System.out.println("error");
		 }
     }	
	
		@Test //5 points --include
		void testMusicConstructor0() {
			Music music = new Music();
			boolean actual = ((music.getName() == null && music.getComposer() == null && music.getScore().size() == 0) ? true : false);
			assertEquals(true, actual, "Music's default constructors or getter methods are not properly implemented!");
		}

		@Test //5 points
		void testMusicConstructor1() {
			Note [] note = new Note[3];
			note[0] = new Note(4, 1000,-1);
			note[1] = new Note(15 , 1000,0);
			note[2] = new Note(28 , 1000,1);
			ArrayList<Note> score = new ArrayList<Note>();
			for (int i = 0; i < note.length; i++)
				score.add(note[i]);
			Music music = new Music("composer", "name", score);
			boolean actual = music.getName().compareTo("name") == 0 && music.getComposer().compareTo("composer") == 0 && music.getScore().size() == 3  ;
			actual = actual && music.getScore().get(0).compareTo(note[0]) == 0; 
			assertEquals(true, actual, "Note's constructors or getter methods are not properly implemented!");
		} 
		
		@Test
		void testMusicConstructor2_1() {
			String [] note = {"4  1000 -1", "15  500 0"};
			ArrayList<String> score = new ArrayList<String>();
			for (int i = 0; i < note.length; i++)
				score.add(note[i]);
			Music music = new Music("composer", "name", score);
			boolean actual = music.getName().compareTo("name") == 0 && music.getComposer().compareTo("composer") == 0 && music.getScore().size() == 2  ;
			actual = actual && music.getScore().get(1).getNote() == 15 && music.getScore().get(1).getDuration() == 500 && music.getScore().get(1).getOctave() == 0; 
			assertEquals(true, actual, "Note's second overloaded constructors or getter methods are not properly implemented!");
			
		}
		@Test
		void testMusicConstructor2_2() {
			String [] note = {"4  1000 -1", "15  500 0"};
			ArrayList<String> score = new ArrayList<String>();
			for (int i = 0; i < note.length; i++)
				score.add(note[i]);
			Music music = new Music("composer", "name", score);
			boolean actual = music.getExceptionCode() == 0 ;
			assertEquals(true, actual, "exceptionCode was not properly initialized in the second overloaded constructors of Music!");
		}
		
		@Test // 1 point  --include
		void testMusicCompareTo1() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			Note [] note2 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
			ArrayList<Note> score1 = new ArrayList<Note>();
			ArrayList<Note> score2 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) {
				score1.add(note1[i]);
				score2.add(note2[i]);
			}
			Music music1 = new Music("composer", "name", score1);
			Music music2 = new Music("composer", "name", score2);
			boolean actual = music1.compareTo(music2) == 0;
			assertEquals(true, actual, "Music's compareTo() is not properly implemented!");
		}

		@Test // 1 point
		void testMusicCompareTo2() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			Note [] note2 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
			ArrayList<Note> score1 = new ArrayList<Note>();
			ArrayList<Note> score2 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) {
				score1.add(note1[i]);
				score2.add(note2[i]);
			}
			Music music1 = new Music("Composer", "name", score1);
			Music music2 = new Music("composer", "name", score2);
			boolean actual = music1.compareTo(music2) == 0;
			assertEquals(true, actual, "Music's compareTo() is not properly implemented!");
		}
		
		@Test // 1 point  --include
		void testMusicCompareTo3() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			Note [] note2 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
			ArrayList<Note> score1 = new ArrayList<Note>();
			ArrayList<Note> score2 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) {
				score1.add(note1[i]);
				score2.add(note2[i]);
			}
			Music music1 = new Music("composer", "name1", score1);
			Music music2 = new Music("composer", "name2", score2);
			boolean actual = music1.compareTo(music2) == 0;
			assertEquals(false, actual, "Music's compareTo() is not properly implemented!");
		}
		
		@Test // 1 point
		void testMusicCompareTo4() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			Note [] note2 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
			ArrayList<Note> score1 = new ArrayList<Note>();
			ArrayList<Note> score2 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) {
				score1.add(note1[i]);
				score2.add(note2[i]);
			}
			Music music1 = new Music("composer", "name1", score1);
			Music music2 = new Music("composer", "name2", score2);
			assertEquals(-1, music1.compareTo(music2), "Music's compareTo() does not reurn -1 when the objects are not the same!");
		}
		
		@Test // 1 point
		void testMusicCompareTo5() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			ArrayList<Note> score1 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++)
				score1.add(note1[i]);
			Music music1 = new Music("composer", "name1", score1);
			Music music2 = null;
			music1.compareTo(music2);
			assertEquals(-1,music1.getExceptionCode() , "Music's compareTo() does not set exceptionCode properly and/or getException does not existe!");
		}
		@Test // 1 point
		void testMusicCompareTo6() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			ArrayList<Note> score1 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++)
				score1.add(note1[i]);
			Music music1 = new Music("composer", "name1", score1);
			Note music2 = new Note();
			music1.compareTo(music2);
			assertEquals(-2,music1.getExceptionCode() , "Music's compareTo() does not set exceptionCode properly and/or getException does not existe!");
		}
		@Test // 1 point --include
		void testCompositionInScoreByGetter() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			ArrayList<Note> score1 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) 
				score1.add(note1[i]);
			Music music1 = new Music("composer", "name1", score1);
			boolean actual = music1.getScore() != score1 && music1.getScore().get(0) != score1.get(0);
			assertEquals(true, actual, "Composition was not implemented correctly in the getter method");
			
		}
		@Test // 1 point
		void testCompositionInScoreBySetter() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			ArrayList<Note> score1 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) 
				score1.add(note1[i]);
			Music music1 = new Music("composer", "name1", new ArrayList<Note>());
			music1.setScore(score1);
			score1.set(0, null);
			boolean actual = music1.getScore().get(0) != score1.get(0);
			assertEquals(true, actual, "Composition was not implemented correctly in the setter method");
			
		}
	 
	
		@Test // 1 point  -- include
		void testReadFile1() {
			PerformingArt.readFile("AFileThatDoesnotExist");
			assertEquals(-1, PerformingArt.exceptionCode, "readFile does not handle the exception correctly");
		}
		
		@Test // 1 point
		void testReadFile2() {
			PerformingArt.readFile("music");
			assertEquals(0, PerformingArt.exceptionCode, "readFile does not initialize exceptionCode correctly");
		}
		@Test // 1 point  -- include
		void testReadFile3() {
			//For this tester to works properly, create a file called music1 and store the content of list2 (below) in the file.
			List<String> list = (ArrayList<String>) PerformingArt.readFile("music1"); 
			String[] list2 = {"48 1000 3", "68 1000 4", "2 1000 -1", "108 1000 8", "51 1000 3", "59 1000 3", "33 1000 1", "48 1000 3", "93 1000 6", "102 1000 7"};
			boolean equal = list2.length == list.size(); 
			if (equal)
				for (int i = 0; i < list2.length; i++)
					if((list2[i].trim()).compareTo((list.get(i).trim())) != 0){
						equal = false; 
						break;
					}
			assertEquals(true, equal, "readFile does not read the file correctly");
		}

		@Test // 1 point 
		void testReadFile4() {
			List<String> container = new ArrayList<String>(); 
			Scanner sc = null; 
			try {
				sc = new Scanner (new File("music"));
				while(sc.hasNext()) {
					container.add(sc.nextLine());
				}
				sc.close();
			} catch (Exception e) {
				System.out.println("Error");
			}

			List<String> list = (ArrayList<String>) PerformingArt.readFile("music");
			boolean equal = container.size() == list.size(); 
			if (equal)
				for (int i = 0; i < container.size(); i++)
					if((container.get(i).trim()).compareTo((list.get(i).trim())) != 0){
						equal = false; 
						break;
					}
			assertEquals(true, equal, "readFile does not read the file correctly");
		}

}
