package online_radio_database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PlayList playList = new PlayList();

        int cycles = Integer.parseInt(reader.readLine());


            for (int i = 0; i <cycles ; i++) {
                String[] songInfo = reader.readLine().split(";");
                try {
                    Song newSong = new Song(songInfo[0], songInfo[1], songInfo[2]);
                    playList.addSongToPlayList(newSong);
                    System.out.println("Song added.");
                }
                catch (InvalidSongException ise) {
                    System.out.println(ise.getMessage());
                }
            }
            System.out.println(playList);
    }
}
