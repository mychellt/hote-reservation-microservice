package gft.challenge.hotel.reservation.core.command;

public interface Command<R> {
    R process(final Context context);
}
