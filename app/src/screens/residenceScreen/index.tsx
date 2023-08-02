import React, { useState, useEffect } from 'react';
import { windowWidth, windowHeight } from '../../constants';
import axios from 'axios';
import { baseUrl } from '../../constants';
import { Avatar, Button, Card, Text, IconButton } from 'react-native-paper';

import {
  SafeAreaView,
  StatusBar,
  StyleSheet,
  View,
} from 'react-native';
import { ResidenceContactProps, ResidenceProps } from '../../types';


function ResidenceScreen({ navigation }: any): JSX.Element {
  const [residences, setResidences] = useState([]);
  const [residencesContact, setResidencesContact] = useState([]);


  const getData = async () => {
    console.log('ResidenceScreen getData', 'OK');
    await axios.get(baseUrl + 'residence', {}
    ).then((response) => {
      const residenceContact = axios.get(baseUrl + 'residenceContact', {}
      ).then((response) => {
        setResidencesContact(response.data.content)
      }).catch(function (error) {
        console.log('error', error.message);
      });
      setResidences(response.data.content);
    }).catch(function (error) {
      console.log('error', error.message);
    });
  }

  useEffect(() => {
    getData();
  }, []);


  return (
    <SafeAreaView>
      <StatusBar backgroundColor={'rgba(0,0,0, 0.9)'} />
      <View style={styles.mainPage}>
        <Card.Title
          title="Card Title"
          subtitle="Card Subtitle"
          left={(props) => <Avatar.Icon {...props} icon="folder" />}
          right={(props) => <IconButton {...props} icon="dots-vertical" onPress={() => { }} />}
        />
        {residences.map((item: ResidenceProps, idx) => (
          <Card key={idx}>
            <Card.Cover source={{ uri: 'https://picsum.photos/800' }} />
            <Card.Title
              title={item.title}
            />
            <Card.Content>
              {residencesContact?.map((contact: ResidenceContactProps) => (
                (contact.residenceId === item.id)
                  ? <>
                    <Text variant="titleLarge">{'Контакты:'}</Text>
                    <Text variant="bodyMedium">{'Адрес:' + contact.address}</Text>
                    <Text variant="bodyMedium">{'Телефон:' + contact.phone}</Text>
                    <Text variant="bodyMedium">{'Email:' + contact.email}</Text>
                  </>
                  : <></>
              ))}
            </Card.Content>
            <Card.Actions>
              <Button>{'Редактировать'}</Button>
              <Button>{'Инвентаризация'}</Button>
            </Card.Actions>
          </Card>
        ))}
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  mainPage: {
    // width: windowWidth,
    height: windowHeight,
    display: 'flex',
    flexDirection: 'column',
    // justifyContent: 'space-between',
    // alignItems: 'center',
    backgroundColor: 'rgba(0,0,0, 0.9)',
    padding: 15,
  },
  questions: {
    marginBottom: 10,
    borderLeftWidth: 2,
    borderLeftColor: 'yellow',
    borderRightWidth: 2,
    borderRightColor: 'yellow',
  },
  question: {
    backgroundColor: 'rgba(0,0,0, 0.9)',
    display: 'flex',
    flexDirection: 'row',
    padding: 10,

    marginBottom: 8,
  },
  questionsTitle: {
    fontSize: 18,
    letterSpacing: 1,
    textAlign: 'center',
    marginTop: 5,
    color: '#00F0FF',
    paddingBottom: 15,
  },
  questionTitle: {
    color: '#fcee0a',
    marginRight: 10,
  },
  questionDescription: {
    color: '#FFFFFF',
  },
  btn: {
    borderRadius: 4,
    padding: 10,
    elevation: 2,
    borderWidth: 2,
    borderColor: '#00F0FF',
    marginBottom: 8,
  },
  btnOpen: {
    // backgroundColor: 'rgba(252,238,10,.15)',
  },
  btnTextStyle: {
    fontStyle: 'italic',
    color: '#e53f2a',
    fontWeight: 'bold',
    textAlign: 'center',
    fontSize: 14,
  },
});

export default ResidenceScreen;
