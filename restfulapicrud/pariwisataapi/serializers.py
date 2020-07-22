from rest_framework import serializers
from .models import Pariwisata


class PariwisataSerializer(serializers.ModelSerializer):
    class Meta:
        model = Pariwisata
        fields = '__all__'
