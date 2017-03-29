package com.project;

import com.hazelcast.jet.Jet;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.jet.stream.IStreamMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author armdev
 */
public class Analizer {

    public static void parseAndSaveHashTags(final String twitterSource) {
        JetInstance jet = Jet.newJetInstance();
        Jet.newJetInstance();
        IStreamMap<Long, HashTag> hashTagsList = jet.getMap("hashTags");
        try {
            Pattern HASHTAGPATTERN = Pattern.compile("#(\\w+|\\W+)");
            Matcher mat = HASHTAGPATTERN.matcher(twitterSource);
            long i = 1;
            while (mat.find()) {
                hashTagsList.put(i++, new HashTag(i++, mat.group(1)));
            }
            System.out.println("HashTag Count is###### " + hashTagsList.stream().count());
            Jet.shutdownAll();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        String source = "Want to see #microservices & Java EE in action? Come to our booth for the Payara Micro demo #JavaLand #javaee #java . "
                + "I have had a great time developing with Java EE 7 and I will make new projects with it\". "
                + "http://blog.rahmannet.net/2017/01/java-ee-7-in-production-at-eko.html … #javaee #java #javaee7";
        Analizer.parseAndSaveHashTags(source);

    }

}
