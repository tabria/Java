package online_radio_database;

public class InvalidArtistNameException extends InvalidSongException {

    public InvalidArtistNameException(String message) {
        super(message);
    }
}
