package ca.pitt.demo.quarkus.restapi;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeMathResourceIT extends MathResourceTest {

    // Execute the same tests but in native mode.
}