package univerranking.uz.univerranking.Exception;

public class UniversityNotFoundException extends RuntimeException {
    public UniversityNotFoundException(String s) {
        super(s);
    }
    public UniversityNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
