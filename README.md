# GrayScale Image Converter

The **GrayScale** class provides functionality to convert a color image to grayscale using the luminosity method. The luminosity method calculates the grayscale value by applying specific weights to the red, green, and blue components of each pixel.

## Formula

The formula used for calculating the grayscale value is:
```gray = 0.21 * red + 0.72 * green + 0.07 * blue```

This formula works because the human eye perceives green more strongly than red, and red more strongly than blue. The weights (0.21, 0.72, 0.07) are chosen to reflect the relative luminance of each color component as perceived by the human eye.

## Algorithm

1. **Read the image from a file.**
2. **Retrieve the pixels array from the image.**
3. **For each pixel:**
    - Extract the alpha, red, green, and blue components.
    - Calculate the grayscale value using the formula: `gray = 0.21 * red + 0.72 * green + 0.07 * blue`.
    - Replace the RGB value with the calculated grayscale value.
4. **Set the modified pixels array back to the image.**
5. **Write the modified image to a new file.**

## Usage

1. **Specify the input and output file paths.**
2. **Run the main method to perform the conversion.**
