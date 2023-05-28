package com.example.diploma.services;

import lombok.Data;
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.VideoWriter;

@Data
public class VideoProcessor {

    CascadeClassifier plateDetector = new CascadeClassifier("src/main/resources/haarcascade_plate_number.xml");

    VideoCapture videoCapture = new VideoCapture("src/main/resources/static/video/test.mp4");
    VideoWriter videoWriter = new VideoWriter("src/main/resources/static/video/savedVideo.mpeg"
            , VideoWriter.fourcc('m', 'j', 'p', 'g')
            , 30.0, new Size(640, 480));


    public void process() {
        while (videoCapture.grab()) {
            Mat frame = new Mat();
            Mat grayFrame = new Mat();
            Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);
            MatOfRect plates = new MatOfRect();
            videoCapture.read(frame);
            plateDetector.detectMultiScale(grayFrame, plates);


            Rect[] platesArray = plates.toArray();
            for (int i = 0; i < platesArray.length; i++) {
                Rect plate = platesArray[i];
                Imgproc.rectangle(frame, plate.tl(), plate.br(), new Scalar(0, 255, 0), 2);
            }

            videoWriter.write(frame);
        }
        videoCapture.release();
        videoWriter.release();
    }

}
