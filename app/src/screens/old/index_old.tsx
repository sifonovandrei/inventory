import React from 'react';
import {windowWidth, windowHeight} from '../../constants';
import { Dimensions } from 'react-native';

import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Button,
  Text,
  useColorScheme,
  View,
  Image,
} from 'react-native';

import {
  Colors,
} from 'react-native/Libraries/NewAppScreen';



function HomeScreen({navigation}: any): JSX.Element {
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
        source={{
          uri: 'https://chillywilly.club/uploads/posts/2023-03/1679004666_chillywilly-club-p-anime-personazhi-na-prozrachnom-fone-art-d-24.jpg'}}
      />
          </View>
        <View style={styles.buttonsBlock}>
          <View style={styles.actionBlock}>
            <Image
        style={styles.action}
        source={{
          uri: 'https://i.pinimg.com/originals/64/04/4d/64044d17f390f8c2042ce6cdc7f0be0d.gif',
        }}
      />
             <Image
        style={styles.action}
        source={{
          uri: 'https://celes.club/uploads/posts/2022-10/1667053506_6-celes-club-p-art-kun-instagram-6.jpg',
        }}
      />
          </View>
          <View style={styles.actionBlock}>
         
      <Image
        style={styles.action}
        source={{
          uri: 'https://i.etsystatic.com/isla/56d7d8/57551675/isla_fullxfull.57551675_n4l1xajk.jpg?version=0',
        }}
      />
       <Image
        style={styles.action}
        source={{
          uri: 'https://animeslayers.ru/wp-content/uploads/kartinki/photoshop/dlyafotoshopa2.png',
        }}
      />
          </View> 
          <Button 
              title="Go to Anime question... OK?"
              onPress={() => navigation.navigate('Anime')}
            />
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
  tinyLogo: {
    width: 99,
    height: 99,
  },
  buttonsBlock: {
    transform: [
      { perspective: 850 },
      { translateX: + Dimensions.get('window').width * 0.24 },
      { rotateY: '45deg'},

    ],
  },
  actionBlock: {
    display: 'flex',
    flexDirection: 'row',
  },
  action: {
    margin: 10,
    borderColor: '#61fabf',
    borderWidth: 2,
    borderRadius: 4,
    width: 100,
    height:100,
  },
  mainImage :{
    position:'absolute',
    marginTop:-130,
    marginLeft:-300,
height:600,
width:500,
transform: [
    { rotateY: '180deg'},
],
  }
});

export default HomeScreen;
