
/**
 * A class that runs implements several simple transformations on 2D image arrays.
 * <p>
 * This file contains stub code for your image transformation methods that are called by the main
 * class. You will do your work for this MP in this file.
 * <p>
 * Note that you can make several assumptions about the images passed to your functions, both by the
 * web front end and by our testing harness:
 * <ul>
 * <li>You will not be passed empty images.</li>
 * <li>All images will have even width and height.</li>
 * </ul>
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/4/">MP4 Documentation</a>
 */
public class Transform {

    /**
     * Default amount to shift an image's position. Not used by the testing suite, so feel free to
     * change this value.
     */
    public static final int DEFAULT_POSITION_SHIFT = 16;

    /**
     * Pixel value to use as filler when you don't have any valid data. All white with complete
     * transparency. DO NOT CHANGE THIS VALUE: the testing suite relies on it.
     */
    public static final int FILL_VALUE = 0x00FFFFFF;

    /**
     * Shift the image left by the specified amount.
     * <p>
     * Any pixels shifted in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to shift to the left
     * @param amount the amount to shift the image to the left
     * @return the shifted image
     */
    public static int[][] shiftLeft(final int[][] originalImage, final int amount) {
        int[][] shiftLeftImage = new int[originalImage.length][originalImage[0].length];
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[0].length; j++) {
                    if ((i + amount) > (originalImage.length - 1)) {
                       shiftLeftImage[i][j] = FILL_VALUE;
                    } else {
                        shiftLeftImage[i][j] = originalImage[i + amount][j];
                    }
                }
            }
        return shiftLeftImage;
    }
    /**
     * @param originalImage the image to shift to the right
     * @param amount the amount to shift the image to the right
     * @return the shifted image
     */
    public static int[][] shiftRight(final int[][] originalImage, final int amount) {
        int[][] shiftRightImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                if ((i < amount)) { // original if (i - amount < 0)
                   shiftRightImage[i][j] = FILL_VALUE;
                } else {
                    shiftRightImage[i][j] = originalImage[i - amount][j];
                }
            }
        }
    return shiftRightImage;
    }
    /**
     * @param originalImage the image to shift up
     * @param amount the amount to shift the image up
     * @return the shifted image
     */
    public static int[][] shiftUp(final int[][] originalImage, final int amount) {
        int[][] shiftDownImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                if ((j + amount) > (originalImage[0].length) - 1) {
                   shiftDownImage[i][j] = FILL_VALUE;
                } else {
                    shiftDownImage[i][j] = originalImage[i][j + amount];
                }
            }
        }
    return shiftDownImage;
    }

    /**
     * @param originalImage the image to shift down
     * @param amount the amount to shift the image down
     * @return the shifted image
     */
    public static int[][] shiftDown(final int[][] originalImage, final int amount) {
        int[][] shiftUpImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                if ((j - amount) < 0) { // original if (j - amount < 0)
                   shiftUpImage[i][j] = FILL_VALUE;
                } else {
                    shiftUpImage[i][j] = originalImage[i][j - amount];
                }
            }
        }
    return shiftUpImage;
    }

    /**
     * Rotate the image left by 90 degrees around its center.
     * <p>
     * Any pixels rotated in from off screen should be filled with FILL_VALUE. This function <i>does
     * not modify the original image</i>.
     *
     * @param originalImage the image to rotate left 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateLeft(final int[][] originalImage) {
        int[][] rotateLImage = new int[originalImage.length][originalImage[0].length];
        double iOrigin = (originalImage.length - 1) / 2.0; //testing
        double jOrigin = (originalImage[0].length - 1) / 2.0; //testing
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                double newI = i - iOrigin;
                double newJ = j - jOrigin;
                int orig1 = (int) Math.round(iOrigin - newJ);
                int orig2 = (int) Math.round(jOrigin + newI);
                if ((orig1 < 0 || orig1 >= originalImage.length)
                        || (orig2 < 0 || orig2 >= originalImage[0].length)) {
                    rotateLImage[i][j] = FILL_VALUE;
                } else {
                rotateLImage[i][j] = originalImage[orig1][orig2];
                }
            }
    }
        return rotateLImage;
    }

    /**
     @param originalImage the image to rotate right 90 degrees
     * @return the rotated image
     */
    public static int[][] rotateRight(final int[][] originalImage) {
        int[][] rotateRImage = new int[originalImage.length][originalImage[0].length];
        double iOrigin = (originalImage.length - 1) / 2.0; //testing with -1
        double jOrigin = (originalImage[0].length - 1) / 2.0; //testing with -1
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                double newI = i - iOrigin;
                double newJ = j - jOrigin;
                int orig1 = (int) Math.round(iOrigin + newJ);
                int orig2 = (int) Math.round(jOrigin - newI);
                if ((orig1 < 0 || orig1 >= originalImage.length)
                        || (orig2 < 0 || orig2 >= originalImage[0].length)) {
                    rotateRImage[i][j] = FILL_VALUE;
                } else {
                rotateRImage[i][j] = originalImage[orig1][orig2];
                }
            }
    }
        return rotateRImage;
    }

    /**
    @param originalImage the image to flip on vertical axis across its center
    * @return the rotated image
    */
    public static int[][] flipVertical(final int[][] originalImage) {
        int[][] flipVImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                flipVImage[i][j] = originalImage[i][originalImage[0].length - j - 1];
            }
        }
        return flipVImage;
    }


    /**
    @param originalImage the image to flip on horizontal axis across its center
    * @return the rotated image
    */
    public static int[][] flipHorizontal(final int[][] originalImage) {
        int[][] flipHImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                flipHImage[i][j] = originalImage[originalImage.length - i - 1][j];
            }
        }
        return flipHImage;
    }

    /**
     * Default amount to shift colors by. Not used by the testing suite, so feel free to change this
     * value.
     */
    public static final int DEFAULT_COLOR_SHIFT = 32;

    /**
     * Add red to the image.
     * <p>
     * This function <i>does not modify the original image</i>. It should also not generate any new
     * filled pixels.
     *
     * @param originalImage the image to add red to
     * @param amount the amount of red to add
     * @return the recolored image
     */
    public static int[][] moreRed(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        int[][] moreRedImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                redAmount += amount;
                if (redAmount >= magMax) {
                    redAmount = magMax;
                } else if (redAmount <= 0) {
                    redAmount = 0;
                }
                moreRedImage[i][j] = (alphaAmount << mag24) | (blueAmount << mag16)
                        | (greenAmount << mag8) | (redAmount);
            }
        }
        return moreRedImage;
    }


    /**
     * @param originalImage the image to remove red to
     * @param amount the amount of red to remove
     * @return the recolored image
     */
    public static int[][] lessRed(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        int[][] lessRedImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                redAmount -= amount;
                if (redAmount >= magMax) {
                    redAmount = magMax;
                } else if (redAmount <= 0) {
                    redAmount = 0;
                }
                lessRedImage[i][j] = (alphaAmount << mag24) | (blueAmount << mag16)
                        | (greenAmount << mag8) | (redAmount);
            }
        }
        return lessRedImage;
    }

    /**
     * @param originalImage the image to add green to
     * @param amount the amount of green to add
     * @return the recolored image
     */
  /*  public static int[][] moreGreen(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        int[][] moreGreenImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                greenAmount += amount;
                if (greenAmount >= magMax) {
                    greenAmount = magMax;
                } else if (greenAmount <= 0) {
                    greenAmount = 0;
                }
                moreGreenImage[i][j] = (alphaAmount << mag24) | (blueAmount << mag16)
                        | (greenAmount << mag8) | (redAmount);
            }
        }
        return moreGreenImage;
    }
*/
    /**
     * @param originalImage the image to remove green to
     * @param amount the amount of green to remove
     * @return the recolored image
     */
    public static int[][] lessGreen(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        int[][] lessGreenImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                greenAmount -= amount;
                if (greenAmount >= magMax) {
                    greenAmount = magMax;
                } else if (greenAmount <= 0) {
                    greenAmount = 0;
                }
                lessGreenImage[i][j] = (alphaAmount << mag24) | (blueAmount << mag16)
                        | (greenAmount << mag8) | (redAmount);
            }
        }
        return lessGreenImage;
    }

    /**
     * @param originalImage the image to add blue to
     * @param amount the amount of blue to add
     * @return the recolored image
     */
    public static int[][] moreBlue(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        int[][] moreBlueImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                blueAmount += amount;
                if (blueAmount >= magMax) {
                    blueAmount = magMax;
                } else if (blueAmount <= 0) {
                    blueAmount = 0;
                }
                moreBlueImage[i][j] = (alphaAmount << mag24) | (blueAmount << mag16)
                        | (greenAmount << mag8) | (redAmount);
            }
        }
        return moreBlueImage;
    }


    /**
     * @param originalImage the image to remove blue to
     * @param amount the amount of blue to remove
     * @return the recolored image
     */
    public static int[][] lessBlue(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        int[][] lessBlueImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                blueAmount -= amount;
                if (blueAmount >= magMax) {
                    blueAmount = magMax;
                } else if (blueAmount <= 0) {
                    blueAmount = 0;
                }
                lessBlueImage[i][j] = (alphaAmount << mag24) | (blueAmount << mag16)
                        | (greenAmount << mag8) | (redAmount);
            }
        }
        return lessBlueImage;
    }

    /**
     * @param originalImage the image to add alpha to
     * @param amount the amount of alpha to add
     * @return the recolored image
     */
    public static int[][] moreAlpha(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        int[][] moreAlphaImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                alphaAmount += amount;
                if (alphaAmount >= magMax) {
                    alphaAmount = magMax;
                } else if (alphaAmount <= 0) {
                    alphaAmount = 0;
                }
                moreAlphaImage[i][j] = (alphaAmount << mag24) | (blueAmount << mag16)
                        | (greenAmount << mag8) | (redAmount);
            }
        }
        return moreAlphaImage;
    }

    /**
     * @param originalImage the image to remove alpha to
     * @param amount the amount of alpha to remove
     * @return the recolored image
     */
    public static int[][] lessAlpha(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        int[][] lessAlphaImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                alphaAmount -= amount;
                if (alphaAmount >= magMax) {
                    alphaAmount = magMax;
                } else if (alphaAmount <= 0) {
                    alphaAmount = 0;
                }
                lessAlphaImage[i][j] = (alphaAmount << mag24) | (blueAmount << mag16)
                        | (greenAmount << mag8) | (redAmount);
            }
        }
        return lessAlphaImage;
    }

    /**
     * The default resize factor. Not used by the testing suite, so feel free to change this value.
     */
    public static final int DEFAULT_RESIZE_AMOUNT = 2;

    /**
     * Shrink in the vertical axis around the image center.
     * <p>
     * An amount of 2 will result in an image that is half its original height. An amount of 3 will
     * result in an image that's a third of its original height. Any pixels shrunk in from off
     * screen should be filled with FILL_VALUE. This function <i>does not modify the original
     * image</i>.
     *
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's height is reduced
     * @return the shrunken image
     */
    public static int[][] shrinkVertical(final int[][] originalImage, final int amount) {
   return null;
    }

    /**
     * @param originalImage the image to expand
     * @param amount the factor by which the image's height is increased
     * @return the expanded image
     */
    public static int[][] expandVertical(final int[][] originalImage, final int amount) {
        int[][] exVertImage = new int[originalImage.length][originalImage[0].length];
        double jOrigin = ((originalImage[0].length - 1) / 2.0); //testing
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                double newJ = (j - jOrigin) / amount;
                if ((int) Math.round(newJ + jOrigin) < 0
                        || (int) Math.round(newJ + jOrigin) >= originalImage[0].length) {
            exVertImage[i][j] = FILL_VALUE;
        } else {
        exVertImage[i][j] = originalImage[i][(int) Math.round(newJ + jOrigin)];
        }
            }
        }
        return exVertImage;
    }

    /**
     * @param originalImage the image to shrink
     * @param amount the factor by which the image's width is reduced
     * @return the shrunken image
     */
    public static int[][] shrinkHorizontal(final int[][] originalImage, final int amount) {
        return null;
    }

    /**
     * @param originalImage the image to expand
     * @param amount the factor by which the image's width is increased
     * @return the expanded image
     */
    public static int[][] expandHorizontal(final int[][] originalImage, final int amount) {
        int[][] exHorImage = new int[originalImage.length][originalImage[0].length];
        double iOrigin = ((originalImage.length - 1) / 2.0); //testing
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                double newI = (i - iOrigin) / amount;
                if ((int) Math.round(newI + iOrigin) < 0
                        || (int) Math.round(newI + iOrigin) >= originalImage.length) {
            exHorImage[i][j] = FILL_VALUE;
        } else {
        exHorImage[i][j] = originalImage[(int) Math.round(newI + iOrigin)][j];
        }
            }
        }
        return exHorImage;
    }

    /**
     * Remove a green screen mask from an image.
     * <p>
     * This function should remove primarily green pixels from an image and replace them with
     * transparent pixels (FILL_VALUE), allowing you to achieve a green screen effect. Obviously
     * this function will destroy pixels, but it <i>does not modify the original image</i>.
     * <p>
     * While this function is tested by the test suite, only extreme edge cases are used. Getting it
     * work work will with real green screen images is left as a challenge for you.
     *
     * @param originalImage the image to remove a green screen from
     * @return the image with the green screen removed
     */
    public static int[][] greenScreen(final int[][] originalImage) {
     //   final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        //final int magMax = 255;
        int[][] greenScreenImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
               // int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                if (greenAmount > blueAmount + redAmount) {
                    greenScreenImage[i][j] = FILL_VALUE;
            } else {
                greenScreenImage[i][j] = originalImage[i][j];
            }
        }
        }
            return greenScreenImage;
    }
/** @param originalImage the image to make random pic a green screen from
     * @return the originalImage with the random values added
     */
    public static int[][] mystery(final int[][] originalImage) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        final int mag13 = 13;
        final int mag43 = 43;
        final int mag77 = 77;
        int[][] mysteryImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                if (greenAmount >= magMax) {
                    greenAmount = magMax;
                } else if (greenAmount <= 0) {
                    greenAmount = 0;
                }
                if (redAmount >= magMax) {
                    redAmount = magMax;
                } else if (redAmount <= 0) {
                    redAmount = 0;
                }
                if (blueAmount >= magMax) {
                    blueAmount = magMax;
                } else if (blueAmount <= 0) {
                    blueAmount = 0;
                }
                mysteryImage[i][j] = (alphaAmount << mag24) | (blueAmount - mag13 << mag16)
                        | (greenAmount + mag43 << mag8) | (redAmount + mag77);
            }
        }
        return mysteryImage;
    }

    /**
     * A wild and mysterious image transform.
     * <p>
     * You are free to implement this in any way you want. It is not tested rigorously by the test
     * suite, but it should do something (change the original image) and <i>not modify the original
     * image</i>.
     * <p>
     * Call this function mystery. It should take only the original image as a single argument and
     * return a modified image.
     *
     * @param originalImage the image to perform a strange and interesting transform on
     * @return the image transformed in wooly and frightening ways
     */




                                     //***********************************************************\\
                                     // **********************************************************\\

    /**
     *
     * @param originalImage to turn into greyscale
     * @param amount //extra
     * @return greyScaled image.
     */
   /* public static int[][] moreRed(final int[][] originalImage, final int amount) {
           final int divisor = 3;
           final int mag16 = 16;
           final int mag8 = 8;
           final int mag24 = 24;
           final int mag0xff = 0xff;
           int[][] greyScaleImage = new int[originalImage.length][originalImage[0].length];
           for (int i = 0; i < originalImage.length; i++) {
               for (int j = 0; j < originalImage[0].length; j++) {
                   int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                   int redAmount = (originalImage[i][j]) & mag0xff;
                   int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                   int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                   int colorSum = (blueAmount + redAmount + greenAmount) / (divisor);
                  // greyScaleImage[i][j] = colorSum;
                   greyScaleImage[i][j] = (alphaAmount << mag24) | (colorSum << mag16)
                           | (colorSum << mag8) | (colorSum);
               }
           }
    return greyScaleImage;
       }
*/

    /**
     *
     * @param originalImage to turn into binary
     * @param amount //extra
     * @return binary image
     */
    public static int[][] moreGreen(final int[][] originalImage, final int amount) {
        final int mag24 = 24;
        final int mag16 = 16;
        final int mag8 = 8;
        final int mag0xff = 0xff;
        final int magMax = 255;
        final int magMin = 0;
        final int magHalf = 127;
        final int divisor = 3;
        int[][] binaryImage = new int[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[0].length; j++) {
                int blueAmount = (originalImage[i][j] >> mag16) & mag0xff;
                int redAmount = (originalImage[i][j]) & mag0xff;
                int greenAmount = (originalImage[i][j] >> mag8) & mag0xff;
                int alphaAmount = (originalImage[i][j] >> mag24) & mag0xff;
                int colorTest = (blueAmount + redAmount + greenAmount) / (divisor);
                if (colorTest > magHalf) {
                binaryImage[i][j] = (alphaAmount << mag24) | (magMax << mag16)
                        | (magMax << mag8) | (magMax);
        } else {
            binaryImage[i][j] = (alphaAmount << mag24) | (magMin << mag16)
                    | (magMin << mag8) | (magMin);
        }
            }
        }
        return binaryImage;
    }

    
    /**
     * the.
     * @param originalImage -
     * @return -
     */
    public static int[][] inverse(final int[][] originalImage) {
        int[][] changedImage = new int[originalImage.length][originalImage[0].length];

        for (int col = 0; col < originalImage.length; col++) {
            for (int row = 0; row < originalImage[col].length; row++) {

                // & kinda deletes because and gate
                int alpha = (originalImage[col][row] >> ALPHA_SHIFTER) & MAKE_IT_GOOD;
                int blue = (originalImage[col][row] >> BLUE_SHIFTER) & MAKE_IT_GOOD;
                int green = (originalImage[col][row] >> GREEN_SHIFTER) & MAKE_IT_GOOD;
                int red = (originalImage[col][row]) & MAKE_IT_GOOD;

                red = MAX_VALUE - red;
                green = MAX_VALUE - green;
                blue = MAX_VALUE - blue;
                //alpha = MAX_VALUE - alpha

                // | kind adds because or gate
                changedImage[col][row] = (alpha << ALPHA_SHIFTER) | (blue << BLUE_SHIFTER)
                        | (green << GREEN_SHIFTER) | (red);
            }
        }

        return changedImage;
    }












}
