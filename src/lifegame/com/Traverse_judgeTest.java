package lifegame.com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Traverse_judgeTest {
	Traverse_judge traverse_judge = new Traverse_judge(7,7);
	int a[][] = {
					{0,0,0,0,0,0,0},
					{0,1,0,0,0,1,0},
					{0,0,1,0,1,0,0},
					{0,0,0,1,0,0,0},
					{0,0,1,0,1,0,0},
					{0,1,0,0,0,1,0},
					{0,0,0,0,0,0,0}
				};


	@Before
	public void setUp() throws Exception {
		;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTraverse_judge() {
		;
	}

	@Test
	public void testGet_x() {
		assertEquals(7,traverse_judge.get_x());
	}

	@Test
	public void testGet_y() {
		assertEquals(7,traverse_judge.get_y());
	}

	@Test
	public void testJudge() {
	}

	
	@Test
	public void testTraverse() {
		int x = traverse_judge.get_x();
		int y = traverse_judge.get_y();
		int [][] newchessboard = new int[x][y];
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				newchessboard[i][j] = 0;
			}
		}
		for(int i=1;i<x-2;i++) {
			for(int j=1;j<y-2;j++) {
				newchessboard[i][j] = traverse_judge.judge(a,i,j);	
			}
		}	
		int expected[][] = {	
								{0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0},
								{0,0,1,1,1,0,0},
								{0,0,1,0,1,0,0},
								{0,0,1,1,1,0,0},
								{0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0}
							};
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				assertEquals(newchessboard[i][j],expected[i][j]);
			}
		}
	}
}