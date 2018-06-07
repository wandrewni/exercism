import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class HandshakeCalculator {


    public List<Signal> calculateHandshake(int input) {
        List<Signal> signals = new ArrayList<>();
        int tmp = input;
        if (bitInRightmostPlace(tmp))
            signals.add(Signal.WINK);
        tmp = shiftRight(tmp);
        if (bitInRightmostPlace(tmp))
            signals.add(Signal.DOUBLE_BLINK);
        tmp = shiftRight(tmp);
        if (bitInRightmostPlace(tmp))
            signals.add(Signal.CLOSE_YOUR_EYES);
        tmp = shiftRight(tmp);
        if (bitInRightmostPlace(tmp))
            signals.add(Signal.JUMP);
        tmp = shiftRight(tmp);
        if (bitInRightmostPlace(tmp))
            Collections.reverse(signals);
        return signals;
    }

    private int shiftRight(int tmp) {
        return tmp >> 1;
    }

    private boolean bitInRightmostPlace(int tmp) {
        return (tmp & 1) == 1;
    }
}
