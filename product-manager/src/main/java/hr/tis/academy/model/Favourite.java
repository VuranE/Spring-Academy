package hr.tis.academy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FAVOURITE")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPUSER_ID", nullable = false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTRACTION_ID", nullable = false)
    private Attraction attraction;

    public Favourite(AppUser appUser, Attraction attraction) {
        this.appUser = appUser;
        this.attraction = attraction;
    }

    public Favourite() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}
