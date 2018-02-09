public interface MediaPlayer{
	public void play(String audioType, String fileName);
}

public interface AdvancedMediaPlayer{
	public void playVlc(String fileName);
	public void playMp4(String fileName);
}

public class VlcPlayer implements AdvancedMediaPlayer{
	@Override
	public void playVlc(String fileName){
		System.out.println("Playing vlc file. Name: "+ fileName);
	}
	
	@Override
	public void playMp4(String fileName){
		//hold information
	}
}

public class Mp4Player implements AdvacedMediaPlayer{
	@Override
	public void playVlc(String fileName){
		//hold information
	}
	
	@Override
	public void playMp4(String fileName){
		System.out.println("Playing mp4 file. Name: "+ fileName);
	}
}

public class MediaAdapter implements MediaPlayer{
	AdvancedMediaPlayer advancedMusicPlayer;
	
	public MediaAdapter(String audioType){
		if(audioType.equalsIgnoreCase("vlc")){
			advancedMusicPlayer = new VlcPlayer();
		}else if(audioType.equalsIgnoreCase("mp4")){
			advancedMusicPlayer = new Mp4Player();
		}
	}
	
	@Override
	public void play(String audioType, String fileName){
		if(audioType.equalsIgnoreCase("vlc")){
			advancedMusicPlayer.playVlc(fileName);
		}else if(audioType.equalsIgnoreCase("mp4")){
			advancedMusicPlayer.playMp4(fileName);
		}
	}
}

public class AudioPlayer implements MediaPlayer{
	MediaAdapter mediaAdapter;
	
	@Override
	public void play(String audioType, String fileName){
		if(audioType.equalsIgnoreCase("mp3")){
			System.out.println("Playing mp3 file. Name: "+ fileName);
		}else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}else{
			System.out.println("Invalid media. "+ audioType + " format not supported.");
		}
	}
}

public class AdapterDesignT1{
	public static void main(String[] args){
		AudioPlayer audioType = new AudioPlayer();
		
		audioType.play("mp3", "Father Time.mp3");
		audioType.play("mp4", "Soldier Time.mp4");
		audioType.play("vlc", "Destiny.vlc");
		audioType.play("avi", "I walk on my own.avi");
	}
}