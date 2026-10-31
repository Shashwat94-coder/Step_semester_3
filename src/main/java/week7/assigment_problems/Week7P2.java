import java.util.Arrays;

public class Week7P2 {

    static class Playlist {
        private String[] songs;
        private int songCount;

        Playlist(int maxSize) {
            songs = new String[maxSize];
            songCount = 0;
        }

        void addSong(String song) {
            if (songCount < songs.length) {
                songs[songCount] = song;
                songCount++;
            }
        }

        String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println("Count: " + p.getSongCount());
    }
}