package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

enum Secret {
    NO, TIME, VIEW, BOTH
}

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private UUID id;
    @Column
    private String code;
    @Column
    private LocalDateTime date;
    @Column
    private long time = 0;
    @Column
    private int views = 0;
    @Column
    @JsonIgnore
    private Secret secret;

    public boolean isSecret() {
        return !(secret == Secret.NO);
    }

    public Secret getSecret() {
        return secret;
    }

    public void setSecret() {
        if (views > 0 && time > 0)
            secret = Secret.BOTH;
        else if (views > 0)
            secret = Secret.VIEW;
        else if (time > 0)
            secret = Secret.TIME;
        else
            secret = Secret.NO;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public Code() {
        this.date = LocalDateTime.now();
    }


    public String getDate() {
        return CurrentTime.returnString(date);
    }

    public long getTime() {
        return time;
    }

    @JsonProperty(value = "time")
    public long getRemainingTime() {
        return Math.max(time - ChronoUnit.SECONDS.between(date, LocalDateTime.now()), 0);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getViews() {
        return Math.max(views, 0);
    }

    public void setViews(int view) {
        this.views = view;
    }

    @JsonIgnore
    public boolean isValid() {
        switch (secret) {
            case BOTH:
                return views > 0 && getRemainingTime() > 0;
            case TIME:
                return getRemainingTime() > 0;
            default:
                return views > 0;
        }
    }

    public boolean updateAccess() {
        if (views > 0) {
            views--;
            return true;
        }
        return false;
    }

}
