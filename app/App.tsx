import * as React from 'react';
import { View, Text } from 'react-native';
import { NavigationContainer, DefaultTheme } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import HomeScreen from './src/screens/homeScreen/index';
import ResidenceScreen from './src/screens/residenceScreen';

const MyTheme = {
    ...DefaultTheme,
    colors: {
      ...DefaultTheme.colors,
      primary: 'rgb(255, 45, 85)',
    },
  };

const Stack = createNativeStackNavigator();

function App() {
  return (
    <NavigationContainer theme={MyTheme}>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={HomeScreen} 
        options={{
          title: '@Джонни Самуи',
          headerStyle: {
            backgroundColor: '#169def',
          },
          headerTintColor: 'rgba(0,0,0, 0.9)',
          headerTitleStyle: {
            fontSize: 14,
            fontWeight: 'bold',
          },
        }}/>
        <Stack.Screen name="Residence" component={ResidenceScreen} 
        options={{
          title: 'Residences',
          headerStyle: {
            backgroundColor: 'rgba(0,0,0, 0.9)',
          },
          headerTintColor: '#00F0FF',
          headerTitleStyle: {
            fontSize: 14,
            fontWeight: 'bold',
          },
        }}/>
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;