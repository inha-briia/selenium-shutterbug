/*
 * Copyright 2016 Glib Briia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.assertthat.selenium_shutterbug.utils.image;

import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

/**
 * Created by Glib_Briia on 26/06/2016.
 */
public class ImageProcessorTest {

    @Test(expected=UnableToCompareImagesException.class)
    public void testThrowExceptionIfSizeNotMatch() {
            int width = 300;
            int height = 300;
            ImageProcessor.imagesAreEquals(new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB)
                        , new BufferedImage(width,height+1,BufferedImage.TYPE_INT_ARGB),0.0);
    }

    @Test
    public void testImagesShouldBeEqualWhenSizeMatch(){
        int width = 300;
        int height = 300;
        boolean imagesAreEqual = ImageProcessor.imagesAreEquals(new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB)
                , new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB),0.0);
        assertTrue("Images are not equal when size match", imagesAreEqual);
    }
}
