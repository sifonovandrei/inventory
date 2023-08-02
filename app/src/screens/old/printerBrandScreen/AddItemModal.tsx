import React, { useState } from 'react';
import { Alert, Modal, StyleSheet, Text, TouchableHighlight, Button, View, TextInput } from 'react-native';
import axios from 'axios';
import { baseUrl } from '../../../constants';

const AddItemModal = ({ modalVisible, setModalVisible, items, setItems, api }: any) => {

  const [errorMassage, setErrorMassage] = useState(null);
  const [name, onChangeName] = React.useState('');

  const addNewItem = async () => {
    await axios.post(baseUrl + api, {
      name: name,
    }
    ).then((response) => {
      const newItem = response.data;
      onChangeName('');
      setModalVisible(!modalVisible);
      setItems([...items, newItem]);
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
            <Text style={styles.modalText}>New Question</Text>
            <TextInput
              style={styles.input}
              onChangeText={onChangeName}
              value={name}
              placeholder="Название"
            />
            <TouchableHighlight
              style={[styles.button, styles.buttonClose]}
              onPress={() => addNewItem()}>
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
    color: 'white',
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

export default AddItemModal;