/**
 * ImmutableRGB
 * v. 1.0
 * Copyright (c) 4738551@stud.nau.edu.ua
 */
import java.io.Serializable;

/**
 * Color-saving class
 *
 * @author Oleksandr Potapenko (4738551@stud.nau.edu.ua)
 * @version $Id$
 * @since 16.12.2020
 */
final public class ImmutableRGB implements Serializable{

    /**
     * Serialization marker.
     */
    private static final long serialVersionUID = 0x54ef489b3ef2eca3L;

    // Values must be between 0 and 255.
    final private int red;
    final private int green;
    final private int blue;

    final private String name;

    public ImmutableRGB(int red,
                        int green,
                        int blue,
                        String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    private void check(int red,
                       int green,
                       int blue) {
        if (red < 0 || red > 255
                || green < 0 || green > 255
                || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public ImmutableRGB invert() {
        return new ImmutableRGB(255 - red,
                255 - green,
                255 - blue,
                "Inverse of " + name);
    }

    public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(final Object object) {
        return object instanceof ImmutableRGB
                && object.equals(this);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + red;
        result = 31 * result + green;
        result = 31 * result + blue;
        return result;
    }

    @Override
    protected ImmutableRGB clone() {
        ImmutableRGB clone = null;
        try {
            clone = (ImmutableRGB) super.clone();
        }catch(CloneNotSupportedException cns) {
            System.out.println("Error while cloning ImmutableRGB" + cns);
        }
        return clone;
    }
}
