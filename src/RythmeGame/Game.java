package RythmeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread  {
	
	//게임 실행시의 이미지 요소들. 각 키의 영역마다 노트가 떨어지는 경로, 판정선, 게임의 이름등이 표현되는 gameInfo, 
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	//게임 실행 시의 음악관련 요소들. 노래 제목, 실행되는 노래에 관한 변수들 등 
	private String titleName;
	private String musicTitle;
	private Music gameMusic;
	
	//각 노트들을 생성될때마다 관리해줄수 있도록 배열을 만든다
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	
	
	
	public Game (String titleName,String musicTitle) {
		
		this.titleName=titleName;
		this.musicTitle=musicTitle;
		gameMusic=new Music(this.musicTitle,false);
		
		
	}
	
	// 게임 속 그래픽 이미지들을 알맞은 위치를 설정해 그려준다.
	public void screenDraw(Graphics2D g) {
		
		
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		
		g.drawImage(gameInfoImage, 0,660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		
		//노트 리스트에 있는 애들 다 돌면서 그려줌. (사용하지 않는 노트(Miss)는 화면에서 사라지도록)
		for(int i=0;i<noteList.size();i++)
		{
			Note note=noteList.get(i);
			if(!note.isproceeded()) { ////note가 작동하고 있는 상태가 아니라면 해제해줌.
				noteList.remove(i);
				i--;	
			}
			
			else{
				note.screenDraw(g);
			}
		}
		
		//참고로 이 순서 중요함. 순서가 밑일수록 그려질때 더 앞에 그려짐.
		
		
		//흰색 볼드체로 노래 제목 을 띄울 수 있도록.
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		
		// 키보드 키와 매치되는 키의 이름과 점수등을 표시해 줄 수 있도록 한다. 
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.white);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("SPACE", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
		}
	
	// 해당 루트에 해당하는 키를 클릭하고 있을때, 그 루트의 이미지가 변하도록 효과를 준다. 
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
	
	public void releaseD() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressF() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
	
	public void releaseF() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressSpace() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	

	}
	
	public void releaseSpace() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	}
	
	
	public void pressJ() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
	
	public void releaseK() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressL() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();	
	}
	
	
	
	
	
	
	
	@Override
	public void run() {
		
		dropNotes(this.titleName);
		
	}
	
	//나가면 나오던 음악이 더 이상 나오지 않도록 한다.
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	
	public void dropNotes(String titleName) {
		
		
		/*이건 그냥 예시임!  이런식으로 노트 찍을 수 있다는 것. 음악에 맞춰서 새롭게 해야함. 판정선에 떨어지는 시간까지를 계산하는건 Note클래스에서 하는듯.
	 Beat[]beats = {
		new Beat(1000,"S"),  // 1초에 s에 노트가 하나 떨어지도록
		new Beat(2000,"D"),//2초에 d에 노트가 떨어지도록*/
		
		
		//곡에 따라서 비트 초기화
		Beat[]beats = null;
		if(titleName.equals("titleName1")) {//곡 이름..넣기. 
			int startTime=1000 - Main.REACH_TIME *1000;
			beats= new Beat[] {
					new Beat(startTime,"Space"),
			};
		}
		else if(titleName.equals("titleName2")) {
			int startTime=1000;
			beats= new Beat[] {
					new Beat(startTime,"Space"),
		};
		}
	
		else if(titleName.equals("titleName3")) {
			int startTime=1000;
			beats= new Beat[] {
					new Beat(startTime,"Space"),
		};
		}
	 
	 //해당하는 실시간의 노래 시점을 파악해서 그 위치에 맞는 노트를 떨어트림
	 int i=0;
	 gameMusic.start();
	 //노트 떨어지는 텀을 두도록 작성할 수도 있음(지금은 일단 skip)
	 while(true) {
		 if (beats[i].getTime <= gameMusic.getTime()){
			 Note note = new Note(beats[i].getNoteName());
			 note.start();
			 noteList.add(note);
			 i++;
		 
		 }
	 
	 }

	 
	
	 
	 
	}
	
	
	//노트 판정부분 (ing)
	//추가 수정 중.. 
	//노트 판정 부분 input(즉 우리가 누른 키가)이 노트 타입과 일치한다면 (즉 내가 s키를 쳤을때, 그 노트가 s 노트가 맞다면)
		 public void judge(String imput) {
			 for (int i=0; i<noteList.size(); i++) {
				 Note note = noteList.get(i);
				 if(input.equals(note.getNoteType())) {
					 
				 }
			 }
			 
		 }
	
	
}
