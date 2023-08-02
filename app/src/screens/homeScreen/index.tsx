import React from 'react';
import { windowWidth, windowHeight } from '../../constants';
import { Dimensions } from 'react-native';
import { Button } from 'react-native-paper';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  Image,
} from 'react-native';

import {
  Colors,
} from 'react-native/Libraries/NewAppScreen';



function HomeScreen({ navigation }: any): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';
  // const horny = require('./images/horny.png');
  return (
    <SafeAreaView>
      <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={'white'}
      />
      <ScrollView contentInsetAdjustmentBehavior="automatic">
        {/* <Header /> */}
        <View style={styles.mainPage}>
          <View>
            <Image
              style={styles.mainImage}
              source={{ uri: 'https://picsum.photos/800' }}
            />
          </View>
          <View style={styles.buttonsBlock}>
            <Button icon={"alpha-r-box"} mode="contained" onPress={() => navigation.navigate('Residence')}>
              Press me
            </Button>
          </View>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  mainPage: {
    width: windowWidth,
    height: windowHeight,
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white',
  },
  buttonsBlock: {
    position: 'absolute',
    marginTop: -130,
    marginLeft: -300,
  },
  mainImage: {
    height: 600,
    width: 500,
    transform: [
      { rotateY: '180deg' },
    ],
  }
});

export default HomeScreen;
