import java.io.Serializable;
import java.time.LocalDate;


public class DVD implements Serializable{
	private String title;
	private LocalDate releaseDate;
	private String mpaaRating;
	private String director;
	private String studio;
	private String userNote;
	
	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "\n Title: " + title + "\n Release Date: " + releaseDate + "\n Mpaa Rating: " + mpaaRating + "\n Director: "
				+ director + "\n Studio: " + studio + "\n User Note: " + userNote+"\n";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMpaaRating() {
		return mpaaRating;
	}

	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUserNote() {
		return userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	public DVD(String title, LocalDate releaseDate, String mpaaRating, String director, String studio, String userNote) {
		this.title=title;
		this.releaseDate=releaseDate;
		this.mpaaRating=mpaaRating;
		this.director=director;
		this.studio=studio;
		this.userNote=userNote;
	}
}

