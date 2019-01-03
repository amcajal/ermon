/*
 * Proyect:     ERMON.
 * File:        SoundLoader.java
 * Description: Implements operations needed to handle MIDI files.
 * Java:        JDK 7
 * Contact:     Alberto Martin Cajal <amartin.glimpse23@gmail.com>
 * Website:     https://github.com/amcajal/ermon
 * License: GNU GPL v3.0
 * Copyright (C) 2018,2019 Alberto Martin Cajal
 *
 * This file is part of ERMON.
 *
 * ERMON is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ERMON is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ERMON.  If not, see <http://www.gnu.org/licenses/>.
*/

package src;

/* Handle exceptions. */
import java.io.IOException;    
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.InvalidMidiDataException;

/* Handle MIDI files. */
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 * Implements operations to handle MIDI files.
 * 
 * Sequencer and Sequence classes are used to load MIDI files and create the
 * correct channels to play them as sounds.
*/
public class SoundLoader {
    /* CLASS VARIABLES */
    
    /**
     * Data structure containing musical information.
     * 
     * @see Sequence
    */
    Sequence sequence;
    
    /**
     * Software device that plays back a MIDI sequence.
     * 
     * @see Sequence
     * @see Sequencer
    */
    Sequencer sequencer;
    
    /** 
     * Security variable. 
     * 
     * If will be False if MIDI load has failed. 
    */
    boolean soundLoaded;
    
    /* CONSTRUCTORS */
    
    /**
     * Creates channels to MIDI files in order to play them.
    */
    public SoundLoader(){
        try {
            this.sequence = MidiSystem.getSequence(
                    SoundLoader.class.getResource("/media/long_tune.mid"));
            this.sequencer = MidiSystem.getSequencer();
            soundLoaded = true;
        } catch (InvalidMidiDataException ex) {
            soundLoaded = false;
        } catch (IOException ex) {
            soundLoaded = false;
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(SoundLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* METHODS */
    
    /**
     * Plays the loaded MIDI file.
     * 
     * If the MIDI file has not been loaded properly, the method doesnt
     * executes any operation.
     */
    public void playSound() {
        if (soundLoaded == true) {
            try {
                /* Release resources used by the sequencer. */
                this.freeSoundResources();
                this.sequencer.open();
                this.sequencer.setSequence(this.sequence);
                this.sequencer.start();    /* Reproduce the sound. */
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(SoundLoader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(SoundLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Close sequencer in order to release resources.
     *
     * When sound has already been played, sequencer shall be closed, releasing
     * all used resources by it, and preparing it for the next MIDI play.
    */
    public void freeSoundResources (){
        if (this.sequencer.isOpen()) {
            this.sequencer.close();
        }
    }
}
