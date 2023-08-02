import React, { useState } from 'react';
import { Alert, Modal, StyleSheet, Text, TouchableHighlight, Button, View, TextInput } from 'react-native';
import axios from 'axios';
import { baseUrl } from '../../constants';

const NewQuestionModal = ({ modalVisible, setModalVisible, questions, setQuestions }:any) => {

  const [errorMassage, setErrorMassage] = useState(null);
  const [title, onChangeTitle] = React.useState('');
  const [description, onChangeDescription] = React.useState('');

  const addNewQuestion = async () => {
    await axios.post(baseUrl + 'questions', {
      title: title,
      description: description
    }
    ).then((response) => {

      const newQuestion = response.data;
      console.log('questions', questions);
      console.log('questions updated', [...questions, newQuestion]);
      onChangeTitle('');
      onChangeDescription('');
      setModalVisible(!modalVisible);
      setQuestions([...questions, newQuestion]);
    }).catch(function (error) {
      console.log('error', error.message);
      setErrorMassage(error.message);
    });
  }

  return (
    <View style={styles.centeredView}>
      <Modal
        animationType="slide"
        transparent={true}
        visible={modalVisible}
        onRequestClose={() => {
          Alert.alert('Modal has been closed.');
          setModalVisible(!modalVisible);
        }}>
        <View style={styles.centeredView}>
          <View style={styles.modalView}>
            <Text style={styles.modalText}>{'Create you question [Chumba]'}</Text>
            <TextInput
              style={styles.input}
              onChangeText={onChangeTitle}
              value={title}
              placeholder="title"
            />
            <TextInput
              style={styles.input}
              onChangeText={onChangeDescription}
              value={description}
              placeholder="description"
            />
            <TouchableHighlight
              style={[styles.button, styles.buttonClose]}
              onPress={() => addNewQuestion()}>
              <Text style={styles.textStyle}>{'Send'}</Text>
            </TouchableHighlight>
          </View>
        </View>
      </Modal>
    </View>
  );
};

const styles = StyleSheet.create({
  centeredView: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 22,
  },
  modalView: {
    borderWidth: 2,
    borderColor: '#e53f2a',
    margin: 20,
    backgroundColor: 'rgba(0,0,0, 0.9)',
    padding: 10,
    alignItems: 'center',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.25,
    shadowRadius: 4,
    elevation: 5,
  },
  button: {
    padding: 10,
    paddingLeft: 40,
    paddingRight: 40,
    elevation: 2,
  },
  buttonOpen: {
    backgroundColor: '#00F0FF',
  },
  buttonClose: {
    backgroundColor: 'rgba(252,238,10,.15)',
  },
  textStyle: {
    color: '#fcee0a',
    // fontWeight: 'bold',
    textAlign: 'center',
  },
  modalText: {
    letterSpacing: 1,
    textAlign: 'center',
    color: 'white'
  },
  input: {
    height: 40,
    width: 250,
    margin: 12,
    borderWidth: 1,
    padding: 10,
    backgroundColor: 'rgba(249, 237, 216, 0.9)',
  },
});

export default NewQuestionModal;