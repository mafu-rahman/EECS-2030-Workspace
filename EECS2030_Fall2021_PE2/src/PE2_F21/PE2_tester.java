package PE2_F21;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.*;

class PE2_tester {
	@Test 
	void testNoteConstructor0() {
		Note note1 = new Note(); 
		boolean actual = ((note1.getExceptionCode() ==  0 && note1.getNote() == 0 && note1.getOctave() == 0 && note1.getDuration() == 0) ? true : false);
		assertEquals(true, actual, "Note's default constructors or getter methods are not properly implemented!");
	}


	@Test 
	void testNoteCompareTo1() {
		Note note1 = new Note(60, 100, 4); 
		Note note2 = new Note(60, 100, 4); 
		int ret = note1.compareTo(note2); 
		boolean actual = (ret == 0? true : false) && note1.getExceptionCode() == 0; 
		assertEquals(true, actual, "Note's compareTo does not work as expected and/or getExceptionCode is not set properly");
	}

	
	@Test 
	void testNoteCompareTo4() {
		Note note1 = new Note(60, 100, 4); 
		Music note2 = new Music(); 
		int ret = note1.compareTo(note2); 
		int actual = note1.getExceptionCode();
		assertEquals(-2, actual, "getExceptionCode is not set properly for incompatible objects");
	}
	
	
	@Test
	void testValidate_1() {
		Note note1 = new Note(-3, 100, -1); 
		note1.play();
		int actual = note1.getExceptionCode();
		assertEquals(-3, actual, "play does not handle the MismatchException properly for octave -1");
	}

	// This tester checks if validateNote throws an exception. However, it does not check the  type of exception.
	 @Test
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

	
		@Test 
		void testMusicConstructor0() {
			Music music = new Music();
			boolean actual = ((music.getName() == null && music.getComposer() == null && music.getScore().size() == 0) ? true : false);
			assertEquals(true, actual, "Music's default constructors or getter methods are not properly implemented!");
		}

		
		@Test 
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
		
		@Test 
		void testCompositionInScoreByGetter() {
			Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
			ArrayList<Note> score1 = new ArrayList<Note>();
			for (int i = 0; i < note1.length; i++) 
				score1.add(note1[i]);
			Music music1 = new Music("composer", "name1", score1);
			boolean actual = music1.getScore() != score1 && music1.getScore().get(0) != score1.get(0);
			assertEquals(true, actual, "Composition was not implemented correctly in the getter method");
			
		}
	
		@Test
		void testReadFile1() {
			PerformingArt.readFile("AFileThatDoesnotExist");
			assertEquals(-1, PerformingArt.exceptionCode, "readFile does not handle the exception correctly");
		}
		
		@Test
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
		
		// MY TEST METHODS
		@Test
	    void testValidate_2() throws MismatchException {
	        Note note = new Note(3, 100, -2);
	        note.play();
	        int actual = note.getExceptionCode();
	        assertEquals(-3, actual, "The validate() method does not set exceptionCode to -3 for all negative values!");
	    }

	    @Test
	    void testCompareTo1() {
	        Note note = new Note(60, 100, 4);
	        Note note2 = new Note(59, 100, 4);
	        boolean expected = false; //This should be false since both notes are not equal
	        boolean actual = note.getNote() == note2.getNote() && note.getOctave()== note2.getOctave()
	                && note.getExceptionCode() == note2.getExceptionCode();
	        assertEquals(expected, actual, "note.note and note2.note are not supposed to be equal!");
	    }
		
	    @Test
	    void testValidate_100() {
	        int temp = 0;
	        for(int i = -1; i <= 9; i++) {
	            // play all the 127 notes
	            if(i != 9)
	                for(int j = 0; j <= 11; j++) {
	                    Note note = new Note(temp, 0, i);
	                    note.play();
	                    temp++;
	                    assertEquals(0, note.getExceptionCode(), "validate() is not made right");
	                }
	            else
	                for(int j = 0; j <= 7; j++) {
	                    Note note = new Note(temp, 0, i);
	                    note.play();
	                    temp++;
	                    assertEquals(0, note.getExceptionCode(), "validate() is not made right");
	                }
	        }
	    }

	    @Test
	    void testValidate_102() {
	        int temp = -1;
	        int temp2 = 12;
	        for(int i = -1; i <= 9; i++) {
	            Note note = new Note(temp, 0, i);
	            note.play();
	            assertEquals(-3, note.getExceptionCode(), "validate() is not made right");
	            note = new Note(temp2, 0, i);
	            note.play();
	            assertEquals(-3, note.getExceptionCode(), "validate() is not made right");
	            
	            temp += 12;
	            if(i == 8)
	                temp2 += 8;
	            else
	                temp2 += 12;
	        }
	    }
	    
	    @Test
	    void testReadFile2() {
	        PerformingArt.readFile(null);
	        assertEquals(-1, PerformingArt.exceptionCode, "readFile does not handle the exception correctly");
	    }
	    
	    @Test
	    void testMusicConstructor1000() {
	        ArrayList<Note> test = new ArrayList<Note>();
	        test.add(new Note(3, 100, -1));
	        Music music = new Music("someone made it", "some song", test);
	        boolean actual = music.getScore().get(0) == test.get(0);
	        assertEquals(false, actual, "Music's first overloaded constructor does not implement a composition relationship!");
	    }

	    @Test
	    void testMusicConstructor200() {
	        ArrayList<Note> test2 = new ArrayList<Note>();
	        test2.add(new Note(3, 100, -1));
	        Music music = new Music("someone made it", "some song", test2);
	        boolean actual = music.getScore() == test2;
	        assertEquals(false, actual, "Music's first overloaded constructor does not implement a composition relationship!");
	    }
	    
	    @Test
	    void testMusicConstructor150() {
	        String[] list = {"71 455 4", "69 455 4", "71 910 4", "78 454 5", "73 682 5", "74 227 5", "73 227 5", "69 227 4",
	                "71 684 4", "73 226 5", "74 228 5", "76 226 5", "81 227 5", "83 226 5", "81 911 5", "71 910 4", "78 454 5",
	                "81 454 5", "73 455 5", "69 455 4", "71 456 4", "59 456 3", "68 456 4", "76 456 5", "78 455 5", "73 455 5"
	                };
	        List<String> list2 = new ArrayList<String>();
	        for(int i = 0; i < list.length; i++)
	            list2.add(list[i]);
	        
	        Music music = new Music("composer", "song", list2);
	        music.play();
	        assertEquals(0, music.getExceptionCode(), "One of Music's constructors do not work properly!");
	    }
	    
	    @Test
        void testReadFile400() {
            Music music = new Music("Marzieh", "idk", PerformingArt.readFile("music"));
            music.play();
            assertEquals(0, PerformingArt.exceptionCode, "readFile does not handle the exception correctly");
        }
	    
	    @Test
        void testMusicCompareTo100() {
            Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
            Note [] note2 = {new Note(5, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
            ArrayList<Note> score1 = new ArrayList<Note>();
            ArrayList<Note> score2 = new ArrayList<Note>();
            for (int i = 0; i < note1.length; i++) {
                score1.add(note1[i]);
                score2.add(note2[i]);
            }
            Music music1 = new Music("composer", "name", score1);
            Music music2 = new Music("composer", "name", score2);
            boolean actual = music1.compareTo(music2) == 0;
            assertEquals(false, actual, "Music's compareTo() is not properly implemented!");
        }
	    
	    @Test 
	    void testNoteCompareTo100() {
	        Note note1 = new Note(60, 100, 4); 
	        Note note2 = new Note(61, 100, 4); 
	        int ret = note1.compareTo(note2); 
	        boolean actual = (ret == 0? true : false) && note1.getExceptionCode() == 0; 
	        assertEquals(false, actual, "Note's compareTo does not work as expected and/or getExceptionCode is not set properly");
	    }
	    
	    @Test 
	    void testNoteCompareTo101() {
	        Note note1 = new Note(60, 100, 4); 
	        Music note2 = null; 
	        int ret = note1.compareTo(note2); 
	        int actual = note1.getExceptionCode();
	        assertEquals(-1, actual, "getExceptionCode is not set properly for incompatible objects");
	    }
	    
	    @Test
	    void testNoteCompareTo1011() {
	        Note note1 = new Note(60, 100, 4);
	        Music note2 = null;
	        note1.compareTo(note2);
	        int actual = note1.getExceptionCode();
	        int expected = -1;
	        assertEquals(expected, actual, "getExceptionCode is not set properly for incompatible objects");
	    }
	    
	    @Test
	    void testNoteCompareTo102() {
	        Note note1 = new Note(60, 100, 4);
	        Music music = new Music();
	        note1.compareTo(music);
	        int actual = note1.getExceptionCode();
	        int expected = -2;
	        assertEquals(expected, actual, "getExceptionCode should be set to -1 for a ClassCastException!");
	    }
	    
	    @Test 
        void testCompositionInComposerAndNameBySetter() {
            Music music = new Music();
            String word = "WORD!";
            music.setComposer(word);
            music.setName(word);
            boolean actual = music.getComposer() != word && music.getName() != word;
            assertEquals(true, actual, "Composition was not implemented correctly in setName and/or setComposer");            
        }
	    
	    @Test 
	    void testNoteCompareTo103() {
	        Note note1 = new Note(60, 100, 4); 
	        Art note2 = new Note(60, 100, 4); 
	        int ret = note1.compareTo(note2); 
	        boolean actual = (ret == 0? true : false) && note1.getExceptionCode() == 0; 
	        assertEquals(true, actual, "Note's compareTo does not work as expected and/or getExceptionCode is not set properly");
	    }
	    
	    @Test
        void testMusicCompareTo101() {
        Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
        ArrayList<Note> score1 = new ArrayList<Note>();
        for (int i = 0; i < note1.length; i++) {
                score1.add(note1[i]);
        }
            Note note = new Note(60, 100, 4);
            Music music1 = new Music("composer", "name", score1);
            music1.compareTo(note);
            int actual = music1.getExceptionCode();
            int expected = -2;
            assertEquals(expected, actual, "getExceptionCode should be set to -2 for a ClassCastException!");
        }
	    
	    @Test
        void testMusicCompareTo102() {
            Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
            ArrayList<Note> score1 = new ArrayList<Note>();
            for (int i = 0; i < note1.length; i++) {
                score1.add(note1[i]);
            }
            Note note = null;
            Music music1 = new Music("composer", "name", score1);
            music1.compareTo(note);
            int actual = music1.getExceptionCode();
            int expected = -1;
            assertEquals(expected, actual, "getExceptionCode should be set to -1 for a ClassCastException!");
        }
	    
	    @Test 
        void testMusicConstructor100() {
            Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
            ArrayList<Note> score1 = new ArrayList<Note>();
            for (int i = 0; i < note1.length; i++) {
                score1.add(note1[i]);
            }
            String word = "WORD!";
            String anotherWord = "AnotherWord!";
            Music music1 = new Music(word, anotherWord, score1);
            boolean actual = music1.getComposer() != word && music1.getName() != anotherWord;
            assertEquals(true, actual, "Composition for the Music's overloaded constructors or getter methods are not properly implemented!");
        }
	    
	    @Test
	    void testValidate_1001() {
	        Note note1 = new Note(72, 200, 5); 
	        note1.play();
	        int actual = note1.getExceptionCode();
	        assertEquals(0, actual, "play does not handle the note properly for octave 5");
	    }
	    
	    @Test 
	    void testNoteCompareTo104() {
	        Note note1 = new Note(60, 100, 4); 
	        Art note2 = new Note(20, 100, 0); 
	        int ret = note1.compareTo(note2); 
	        boolean actual = (ret == 40? true : false) && note1.getExceptionCode() == 0; 
	        assertEquals(true, actual, "Note's compareTo does not work as expected and/or getExceptionCode is not set properly");
	    }
	    
	    @Test 
	    void testNoteConstructor100() {
	        int note = 15;
	        int duration = 100;
	        int octave = 1;
	        Note note1 = new Note(note, duration, octave);
	        boolean actual = note1.getNote() == note && note1.getDuration() == duration && note1.getOctave() == octave;
	        assertEquals(true, actual, "Aggregation for Note's overloaded constructor is not properly implemented!");
	    }
	    
	  //set composer
        @Test void setComposer(){
            ArrayList<Note> score1 = new ArrayList<Note>();
            Music music1 = new Music("composer", "name", score1);
            music1.setComposer("Rick Astley");
            assertEquals(music1.getComposer(),"Rick Astley", "setComposer is not properly implemented");
        }
        //set note
        @Test void setNote(){
            Note note1 = new Note(60, 100, 4);
            note1.setNote(5);
            assertEquals(note1.getNote(),5, "setNote is not properly implemented");
        }
        
        //set duration
        @Test void setDuration(){
            Note note1 = new Note(60, 100, 4);
            note1.setDuration(110);
            assertEquals(note1.getDuration(),110, "setDuration is not properly implemented");
        }
        //set exceptionCode
        @Test void setExceptionCode(){
            Note note1 = new Note(60, 100, 4);
            note1.setExceptionCode(-2);
            assertEquals(note1.getExceptionCode(),-2, "setExceptionCode is not properly implemented");
        }
        //set octave
        @Test void setOctave(){
            Note note1 = new Note(60, 100, 4);
            note1.setOctave(5);
            assertEquals(note1.getOctave(),5, "setOctave is not properly implemented");
        }
        //set name
        @Test void setName(){
            ArrayList<Note> score1 = new ArrayList<Note>();
            Music music1 = new Music("composer", "name", score1);
            music1.setName("Never Gonna Give You Up");
            assertEquals(music1.getName(),"Never Gonna Give You Up", "setName is not properly implemented");
        }
        
        @Test void setScore1(){
            String[] list = {"71 455 4", "69 455 4", "71 910 4", "78 454 5", "73 682 5", "74 227 5", "73 227 5", "69 227 4",
                    "71 684 4", "73 226 5", "74 228 5", "76 226 5", "81 227 5", "83 226 5", "81 911 5", "71 910 4", "78 454 5",
                    "81 454 5", "73 455 5", "69 455 4", "71 456 4", "59 456 3", "68 456 4", "76 456 5", "78 455 5", "73 455 5"
                    };
            List<String> list2 = new ArrayList<String>();
            for(int i = 0; i < list.length; i++) {
                 list2.add(list[i]);
            }
            Music music1 = new Music("composer", "name", list2);
            List<String> list3 = new ArrayList<String>();
            for(int i = 1; i < list.length; i++) {
                 list3.add(list[i]);
            }
            music1.setScore(list3);
            assertNotEquals(music1.getScore(),list3, "setScore is not properly implemented, needs deep copy");
            }
            
            @Test void setScore2(){
                ArrayList<Note> score1 = new ArrayList<Note>();
                Music music1 = new Music("composer", "name", score1);
                Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
                Note [] note2 = {new Note(5, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)};
                score1 = new ArrayList<Note>();
                ArrayList<Note> score2 = new ArrayList<Note>();
                for (int i = 0; i < note1.length; i++) {
                    score1.add(note1[i]);
                    score2.add(note2[i]);
                }
                music1.setScore(score2);
                assertNotEquals(music1.getScore(),score2, "setScore is not properly implemented, needs deep copy");
            }
            
            @Test
            void testMusicConstructor1500() {
                String[] list = {"71 455 4", "69 455 4", "71 910 4", "78 454 5", "73 682 5", "74 227 5", "73 227 5", "69 227 4",
                        "71 684 4", "73 226 5", "74 228 5", "76 226 5", "81 227 5", "83 226 5", "81 911 5", "71 910 4", "78 454 5",
                        "81 454 5", "73 455 5", "69 455 4", "71 456 4", "59 456 3", "68 456 4", "76 456 5", "78 455 5", "73 455 5"
                        };
                List<String> list2 = new ArrayList<String>();
                for(int i = 0; i < list.length; i++)
                    list2.add(list[i]);            
                Music music = new Music("composer", "song", list2);
                boolean actual = true;
                for (int i = 0; i < list2.size(); i++) {
                    String[] parts = list2.get(i).split(" ");                
                    if(music.getScore().get(i).compareTo(new Note(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]))) != 0){
                        actual = false;
                        break;
                    }
                }
                assertEquals(true, actual, "One of Music's constructors do not work properly!");
            }
            
            @Test
            void testReadFile101() {
                Music music = new Music("Marzieh", "idk", PerformingArt.readFile("music"));
                music.play();
                boolean actual1 = PerformingArt.exceptionCode == 0;
                
                PerformingArt.readFile("AFileThatDoesnotExist");
                
                boolean actual2 = PerformingArt.exceptionCode == -1;
                boolean actual3 = actual1 && actual2;
                assertEquals(true, actual3, "readFile does not handle the exception correctly");
            }
            
            @Test
            void testValidate_101() {
                Note note1 = new Note(72, 200, 10); 
                note1.play();
                boolean actual1 = note1.getExceptionCode() == -3;
                
                Note note2 = new Note(72, 200, -2); 
                note2.play();
                boolean actual2 = note2.getExceptionCode() == -3;
                
                boolean actual = actual1 && actual2;
                assertEquals(true, actual, "validate does not handle the note properly");
            }
            
            @Test 
            void testMusicConstructor00() {
                Music music = new Music();
                boolean actual = ((music.getName() == null && music.getComposer() == null && music.getScore().size() == 0) ? true : false);
                assertEquals(true, actual, "Music's default constructors or getter methods are not properly implemented!");
            }
            
            @Test
            void testValidate_NewEx() {
                int temp = 0;
                for(int i = -1; i <= 9; i++) {
                    // play all the 127 notes
                    if(i != 9)
                        for(int j = 0; j <= 11; j++) {
                            Note note = new Note(temp, 0, i);
                            Note note2 = new Note(-2, 0, i);
                            note2.play();
                            note.play();
                            temp++;
                            assertEquals(0, note.getExceptionCode(), "validate() is not made right");
                            assertEquals(-3, note2.getExceptionCode(), "validate() is not made right");
                        }
                    else
                        for(int j = 0; j <= 7; j++) {
                            
                            Note note = new Note(temp, 0, i);
                            note.play();
                            
                            temp++;
                            assertEquals(0, note.getExceptionCode(), "validate() is not made right");
                        }
                }
            }
            
            @Test 
            void testCompositionInScoreByGetter1() {
                Note [] note1 = {new Note(4, 1000,-1), new Note(15 , 1000,0), new Note(28 , 1000,1)} ;
                ArrayList<Note> score1 = new ArrayList<Note>();
                for (int i = 0; i < note1.length; i++) 
                    score1.add(note1[i]);
                Music music1 = new Music("composer", "name1", score1);
                boolean actual = music1.getScore() != score1 && music1.getScore().get(0) != score1.get(0);
                assertEquals(true, actual, "Composition was not implemented correctly in the getter method");

            }
}