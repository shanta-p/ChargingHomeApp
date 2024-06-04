package com.example.chargingapp.ui

import android.car.Car
import android.car.Car.CAR_WAIT_TIMEOUT_WAIT_FOREVER
import android.car.VehiclePropertyIds
import android.car.hardware.CarPropertyValue
import android.car.hardware.property.CarPropertyManager
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.chargingapp.ui.theme.ChargingAppTheme


/**
 * Created by shanta on 1/5/24
 */
class ChargingHomeActivity: ComponentActivity() {

    private lateinit var mCarPropertyManager: CarPropertyManager
    private lateinit var mCarApiClient: Car
    private val requiredProperties = listOf(
        VehiclePropertyIds.EV_CHARGE_STATE,
        VehiclePropertyIds.EV_CHARGE_SWITCH,
        VehiclePropertyIds.EV_CHARGE_PORT_CONNECTED,
        VehiclePropertyIds.EV_CHARGE_PORT_OPEN,
        VehiclePropertyIds.EV_BATTERY_LEVEL,
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChargingAppTheme {
                ChargingHomeScreen()
            }
        }
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_AUTOMOTIVE)) {
            mCarApiClient =
                Car.createCar(this, null, CAR_WAIT_TIMEOUT_WAIT_FOREVER, mServiceConnectionListener)
        }
    }

    private val mServiceConnectionListener: Car.CarServiceLifecycleListener =
        Car.CarServiceLifecycleListener { car, b ->

            try {
                mCarPropertyManager =
                    car.getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager
                registerPropertyEventListeners()

            } catch (e: Exception) {
            }
        }


    private fun registerPropertyEventListeners() {
        for (propertyId in requiredProperties) {
            if (mCarPropertyManager.getCarPropertyConfig(propertyId) == null) {
                Log.w(
                    "registerPropertyEventListeners", ("register PropertyEventListeners - propertyId: + "
                            + VehiclePropertyIds.toString(propertyId)).toString() + " is not implemented."
                            + " Skipping registering callback."
                )
                continue
            }
            mCarPropertyManager.registerCallback(
                object :CarPropertyManager.CarPropertyEventCallback{
                    override fun onChangeEvent(p0: CarPropertyValue<*>?) {
                        Log.i("onChangeEvent - $propertyId", p0.toString())
                    }

                    override fun onErrorEvent(p0: Int, p1: Int) {
                        Log.i("onErrorEvent - $propertyId", p0.toString().plus(" , ").plus(p1.toString()))
                    }

                } , propertyId,
                CarPropertyManager.SENSOR_RATE_ONCHANGE
            )
        }
    }
}



