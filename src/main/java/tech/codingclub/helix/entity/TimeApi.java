package tech.codingclub.helix.entity;

public class TimeApi {

    public TimeApi(String time_str) {
        this.time_str = time_str;
    }

    private String time_str;

    public TimeApi(Long epoch_time) {
        this.epoch_time = epoch_time;
    }

    private Long epoch_time;





    public TimeApi(String time_str, long epoch_time) {
        this.time_str=time_str;
        this.epoch_time=epoch_time;

    }
}
